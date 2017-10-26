import java.lang.reflect.Array;
import java.util.ArrayList;

public class InspectedArray extends InspectedObject{
	
	private int length;
	private ArrayList<Object> members;
	
	public InspectedArray(Object obj, boolean recursive) {
		
		super(obj, recursive);
		init();
	}
	
	public InspectedArray(InspectedObject parent, Object obj) {
		super(parent, obj);
		init();
	}
	
	private void init() {
		
		length = Array.getLength(getBaseObject());
		initMembers();	
	}
	
	
	private void initMembers() {
		members = new ArrayList<Object>();
		
		for(int i = 0; i < length; i++) {
			Object curObj = Array.get(getBaseObject(), i);
			if(isRecursive()) {
				curObj = InspectedObject.create(curObj, isRecursive());
			}
			members.add(curObj);
		}
	}
	
	
	private String membersToString() {
		
		String result = "";
		
		for(int i = 0; i < members.size(); i++) {
			Object obj = members.get(i);
			result += "\n" + StringExtensions.indent(i + " : " + obj.toString());
		}
		
		return result;
	}
		
	@Override
	public String toString() {
		return super.toString() +
				"\nLength : " + length + 
				"\nMembers : " + membersToString();
	}

}
