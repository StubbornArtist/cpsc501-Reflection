import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public class InspectedConstructor<T extends Member & GenericDeclaration> 
extends InspectedMember{

	private ArrayList<String> parameters;
	
	public InspectedConstructor(T constructor) {
		super(constructor);
		
		parameters = new ArrayList<String>();
		for(TypeVariable<?> p : constructor.getTypeParameters()) {
			addParameter(p.getName());
		}
		
	}
	
	public void addParameter(String param) {
		parameters.add(param);
	}
	
	@Override
	public String toString() {
		
		return super.toString() +
				"\nParameters : " + parameters;
	}
}
