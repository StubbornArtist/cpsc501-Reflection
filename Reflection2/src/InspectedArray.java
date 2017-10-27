import java.lang.reflect.Array;
import java.util.ArrayList;

public class InspectedArray extends InspectedObject{

	private int length;
	
	public InspectedArray(Object obj, boolean recursive){
		super(obj, recursive);
		this.length = Array.getLength(obj);
	}
	
	public InspectedArray(InspectedBaseObject parent, Object arrayObject){
		super(parent, arrayObject);
		this.length = Array.getLength(arrayObject);
	}
	
	public ArrayList<InspectedBaseObject> getMembers(){
		ArrayList<InspectedBaseObject> members = new ArrayList<InspectedBaseObject>();
		for(int i = 0; i < length; i++) {
			members.add(InspectedBaseObject.create(this, Array.get(getBase(), i)));
		}
		
		return members;
	}
	
	@Override
	public String toString(){
		String result = super.toString() + "\nLength : " + length;
		if(length > 0) {
			String members = StringExtensions.lineSeperatedString(getMembers());
			result += "\nMembers : " + StringExtensions.indent(members);
		}
		return result;
	}
}
