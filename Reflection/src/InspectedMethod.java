import java.lang.reflect.Method;
import java.util.ArrayList;

public class InspectedMethod extends InspectedExecutable{
	
	private String returnType;
	private ArrayList<String> exceptionTypes;
	
	public InspectedMethod(Method m) {
		super(m);
				
		returnType = m.getReturnType().getName();
		
		exceptionTypes = new ArrayList<String>();
		for(Class<?> e : m.getExceptionTypes()) {
			exceptionTypes.add(e.getName());
		}
		
	}
	
	@Override
	public String toString() {
		String result = super.toString() + "\nReturn Type : " + returnType;
		
		if(!exceptionTypes.isEmpty())
			result += "\nExceptions : " + exceptionTypes;
		
		return result;
				
	}
	
}
