import java.lang.reflect.Field;


public class InspectedField extends InspectedMember{

	private Field base;
	
	public InspectedField(Field field) {
		super(field);
		base = field;
		base.setAccessible(true);
	}
	
	public InspectedClass getType(){
		
		return new InspectedClass(base.getType());
	}
	
	public Field getField() {
		return base;
	}
	
	public Object getObject(Object container) {
		try {
			Object value =  base.get(container);
			return value;
		}
		catch(IllegalAccessException e) {
			throw new RuntimeException ();
		}	
	}
	
	

}
