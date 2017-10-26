import java.lang.reflect.Executable;
import java.util.ArrayList;

public class InspectedExecutable extends InspectedMember {
	
	private ArrayList<String> parameterTypes;
	
	public InspectedExecutable(Executable ex) {
		
		super(ex);
		
		ex.setAccessible(true);
		
		parameterTypes = new ArrayList<String>();
		for(Class<?> p : ex.getParameterTypes()) {
			parameterTypes.add(p.getName());
		}

	}
	
	@Override
	public String toString() {
		String result = super.toString();
		
		if(!parameterTypes.isEmpty())
			result += "\nParameters: " + parameterTypes;
		
		return result;
	}

}
