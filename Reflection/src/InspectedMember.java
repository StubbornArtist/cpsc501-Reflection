import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public class InspectedMember {
	
	private int modifiers;
	private String name;
	
	public InspectedMember(Member m) {
		modifiers = m.getModifiers();
		name = m.getName();
	}
	
	@Override
	public String toString() {
		return "Name : " + name +
				"\nModifiers : " + Modifier.toString(modifiers);
	}
	
	

}
