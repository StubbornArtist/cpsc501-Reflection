import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class InspectedClass {

	private Class<?> base;
	private ArrayList<InspectedMethod> methods;
	private ArrayList<InspectedExecutable> constructors;

	public InspectedClass(Class<?> classType){
		base = classType;
		methods = getMethods();
		constructors = getConstructors();
	}
	
	public Class<?> getType(){
		return base;
	}
	
	public String getName() {
		return base.getName();
	}
	
	public ArrayList<InspectedMethod> getMethods(){
		ArrayList<InspectedMethod> methods = new ArrayList<InspectedMethod>();
		for(Method m : base.getDeclaredMethods()){
			methods.add(new InspectedMethod(m));
		}
		return methods;
	}
	
	
	public ArrayList<InspectedExecutable> getConstructors(){
		ArrayList<InspectedExecutable> constructors = new ArrayList<InspectedExecutable>();
		for(Constructor<?> c : base.getDeclaredConstructors()){
			constructors.add(new InspectedExecutable(c));
		}
		return constructors;
	}
	
	public boolean hasSuperClass() {
		return base.getSuperclass() != null;
	}
	
	public boolean hasInterfaces() {
		return base.getInterfaces().length > 0;
	}
	
	public boolean hasFields() {
		return base.getDeclaredFields().length > 0;
	}
	
	public boolean hasMethods() {
		return methods.size() > 0;
	}
	
	public boolean hasConstructors() {
		return constructors.size() > 0;
	}
	
	public InspectedClass getSuperClass(){
		Class<?> superClass = base.getSuperclass();		
		return new InspectedClass(superClass);
	}
	
	
	public ArrayList<InspectedClass> getInterfaces(){
	
		ArrayList<InspectedClass> interfaces = new ArrayList<InspectedClass>();
		for(Class<?> i : base.getInterfaces()){
			interfaces.add(new InspectedClass(i));
		}	
		return interfaces;
	}
	
	public ArrayList<InspectedField> getFields(){
	
		ArrayList<InspectedField> fields = new ArrayList<InspectedField>();
		for(Field f : base.getDeclaredFields()){
			fields.add(new InspectedField(f));
		}	
		return fields;
	}
	
	@Override 
	public boolean equals(Object obj){
	
		if(obj == null) return false;
		
		if(!(obj instanceof InspectedClass)) return false;
	
		return base != null && base.equals(((InspectedClass) obj).getType());
	}
	
	
	private <T extends Object> String membersToString(ArrayList<T> members) {
		String result ="\n\n";
		
		for(Object o : members) {
			result += StringExtensions.indent(o.toString()) + "\n\n";
			
		}
		return result;
	}
		
	
	@Override
	public String toString(){
		String result = "Type : " + base.getName();
		
		if(hasMethods()) {
			result += "\nMethods : "  + membersToString(methods);
		}
		if(hasConstructors()) {
			result += "\nConstructors : " + membersToString(constructors);
		}	
		return result;
	}
	
}
