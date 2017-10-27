import java.util.ArrayList;

public class InspectedObject extends InspectedBaseObject {
		
	public InspectedObject(Object obj, boolean recursive){
		super(obj, recursive);
	}
	
	public InspectedObject(InspectedBaseObject parent, InspectedClass type){
		super(parent, type);
	}

	public InspectedObject(InspectedBaseObject parent, Object obj) {
		super(parent, obj);
	}
		
	private ArrayList<InspectedBaseObject> getInterfaces(){
	
		ArrayList<InspectedBaseObject> temp = new ArrayList<InspectedBaseObject>();
		for(InspectedClass c : getType().getInterfaces()){
			temp.add(create(this, c));
		}
		
		return temp;
	}
		
	
	private String fieldsToString() {
		String result = "\n\n";
		for(InspectedField f : getType().getFields()) {
			result += f + "\nValue : ";
			
			Object value = f.getObject(getBase());
			
			if(isRecursive()) {
				InspectedBaseObject obj; 
				if(value == null) {
					obj = null;
				}
				else {
					obj = create(this, value);
				}
				result +=  "\n" + obj;
			}
			else {
				result += value;
			}
			result += "\n\n";
		}
		return result;
	}
	
	
	
	
	private <T extends Object> String membersToString(ArrayList<T> members) {
		String result ="\n\n";
		
		for(Object o : members) {
			String val;
			if(o == null) {
				val = "null";
			}
			else {
				val = o.toString();
			}
			result += StringExtensions.indent(val) + "\n\n";
			
		}
		return result;
	}
	
	@Override
	public String toString(){
		String result = super.toString();
		if(getType().hasFields()) {
			result+= "\nFields : " + StringExtensions.indent(fieldsToString());
		}
		if(getType().hasInterfaces()) {
			result+= "\nInterfaces : " + membersToString(getInterfaces());
		}
		if(getType().hasSuperClass()) {
			InspectedBaseObject superClass = create(this, getType().getSuperClass());
			result += "\nSuper : \n" + StringExtensions.indent(superClass.toString());
		}
		return result;
	}
}
