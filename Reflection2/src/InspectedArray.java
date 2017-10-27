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
			Object obj = Array.get(getBase(), i);
			members.add(InspectedBaseObject.create(this, obj));
		}
		
		return members;
	}
	
	
	private String membersToString(){
		String result = "\n\n";
		for(InspectedBaseObject obj : getMembers()){
			result += obj + "\n\n";
		}
		return result;
	}
	
	@Override
	public String toString(){
		String result = super.toString() + "\nLength : " + length;
		if(length > 0) {
			result += "\nMembers : " + StringExtensions.indent(membersToString());
		}
		return result;
	}
}
