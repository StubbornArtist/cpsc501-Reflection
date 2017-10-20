import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class InspectedMethod extends InspectedConstructor<Method>{
	
	private String returnType;
	private ArrayList<String> exceptions;
	
	
	public InspectedMethod(Method method) {
		
		super(method);
		setReturnType(method.getReturnType().getName());
		
		exceptions = new ArrayList<String>();
		for(Class<?> e : method.getExceptionTypes()) {
			addException(e.getName());
		}
		
	}
		
	public String getReturnType() {
		return returnType;
	}
	
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
		
	public void addException(String exception) {
		exceptions.add(exception);
	}
			
	@Override
	public String toString() {
		
		return super.toString() + 
				"\nReturn Type : " + getReturnType() + 
				"\nExceptions : " + exceptions;
	}
}
