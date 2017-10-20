import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public class InspectedMember {
	
	private String name;
	private String modifiers;
	
	
	public InspectedMember(Member member) {
		setName(member.getName());
		setModifiers(member.getModifiers());
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setModifiers(int code) {
		this.modifiers = Modifier.toString(code);
	}
	
	public String getModifiers() {
		return modifiers;
	}

	@Override
	public String toString() {
		
		return "\nName : " + getName() +
				"\nModifiers : " + getModifiers();
	}
}
