import java.lang.reflect.Executable;
import java.util.ArrayList;

public class InspectedExecutable extends InspectedMember {
	
	private ArrayList<String> parameterTypes;
	private Executable executable;
	
	public InspectedExecutable(Executable ex) {
		
		super(ex);
		executable = ex;
		
		parameterTypes = new ArrayList<String>();
		for(Class<?> p : ex.getParameterTypes()) {
			parameterTypes.add(p.getName());
		}

	}
	public Executable getExecutable() {
		return executable;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		
		if(!parameterTypes.isEmpty())
			result += "\nParameters : " + parameterTypes;
		
		return result;
	}

}
