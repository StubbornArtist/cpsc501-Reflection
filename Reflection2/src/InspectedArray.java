import java.lang.reflect.Array;
import java.util.ArrayList;

public class InspectedArray extends InspectedObject{

	private int length;
	private ArrayList<InspectedBaseObject> members;
	
	public InspectedArray(Object obj, boolean recursive){
		super(obj, recursive);
		this.length = Array.getLength(obj);
		members = getMembers();
	}
	
	public InspectedArray(InspectedBaseObject parent, Object arrayObject){
		super(parent, arrayObject);
		this.length = Array.getLength(arrayObject);
		members = getMembers();
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
			String memberStr = StringExtensions.lineSeperatedString(members);
			result += "\nMembers : " + StringExtensions.indent(memberStr);
		}
		return result;
	}
}
