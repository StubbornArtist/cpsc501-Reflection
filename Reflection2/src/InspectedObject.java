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
	
	private InspectedBaseObject getSuperClass() {
		return create(this, getType().getSuperClass());
	}
		
	
	private String fieldsToString() {
		String result = "\n\n";
		for(InspectedField f : getType().getFields()) {
			result += fieldValue(f);
			result += "\n\n";
		}
		return result;
	}
	
	
	private String fieldValue(InspectedField field) {
		Class<?> baseClass = field.getType().getType();
		Object value = field.getObject(getBase());
		
		if(value == null) return field + "\nType : " + baseClass + "\nValue : null";
		
		if(baseClass.isPrimitive()) {
			return field + "\nType : " + baseClass + "\nValue : " + value; 
		}
		
		return field + "\n" + create(this, value);
	}
	
	@Override
	public String toString(){
		String result = super.toString();
		if(getType().hasFields()) {
			result+= "\nFields : " + StringExtensions.indent(fieldsToString());
		}
		if(getType().hasInterfaces()) {
			String interfaces = StringExtensions.lineSeperatedString(getInterfaces());
			result+= "\nInterfaces : " + StringExtensions.indent(interfaces);
		}
		if(getType().hasSuperClass()) {
			result += "\nSuper : \n" + StringExtensions.indent(getSuperClass().toString());
		}
		return result;
	}
}
