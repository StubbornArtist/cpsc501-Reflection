import java.lang.reflect.Field;


public class InspectedField extends InspectedMember{

	private Object value;
	
	public InspectedField(Field field, InspectedObject container) {
		
		super(field);
		field.setAccessible(true);
		try {
			
			Object temp = field.get(container.getBaseObject());
			
			if(container.isRecursive() && !(temp == null)) {
				value = InspectedObject.create(container, temp);
			}
			else {
				value = temp;
			}
			
		}
		catch(IllegalAccessException e) {
			
			throw new RuntimeException("Field inaccessible : unexpected error");
		}	
	}
	
	
	@Override
	public String toString() {
		
		return super.toString() +
				"\nValue : " + value;
	}
}
