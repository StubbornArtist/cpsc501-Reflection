import java.lang.reflect.Method;
import java.util.ArrayList;

public class InspectedMethod extends InspectedExecutable{
	
	private String returnType;
	private ArrayList<String> exceptionTypes;
	private Method base;
	
	public InspectedMethod(Method m) {
		super(m);
		m.setAccessible(true);
		returnType = m.getReturnType().getName();
		base = m;
		
		exceptionTypes = new ArrayList<String>();
		for(Class<?> e : m.getExceptionTypes()) {
			exceptionTypes.add(e.getName());
		}
		
	}
	public Method getMethod() {
		return base;
	}
	@Override
	public String toString() {
		String result = super.toString() + "\nReturn Type : " + returnType;
		
		if(!exceptionTypes.isEmpty())
			result += "\nExceptions : " + exceptionTypes;
		
		return result;
				
	}
	
}
