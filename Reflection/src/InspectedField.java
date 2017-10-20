import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class InspectedField extends InspectedMember{
	
	private String type;
	
	public InspectedField(Field field) {
		super(field);
		setType(field.getType().getName());
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + 
				"\nType : " + getType(); 
	}

}
