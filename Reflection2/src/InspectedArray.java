import java.lang.reflect.Array;
import java.util.ArrayList;

public class InspectedArray extends InspectedObject{

	private int length;
	
	public InspectedArray(Object obj, boolean recursive){
		super(obj, recursive);
	}
	
	public InspectedArray(InspectedBaseObject parent, Object arrayObject){
		super(parent, arrayObject);
		this.length = Array.getLength(arrayObject);
	}
	
	private String membersToString(){
		String result = "\n";
		for(int i = 0; i < length; i++){
			InspectedBaseObject obj =  InspectedBaseObject.create(this, Array.get(getBase(), i));
			result += "\n" + i + " : " + obj;
		}
		return result;
	}
	
	@Override
	public String toString(){
		return super.toString() +
		"\nLength : " + length +
		"\nMembers : " + membersToString();
	}
}
