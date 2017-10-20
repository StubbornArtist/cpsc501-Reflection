import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class InspectedClass {

	private String name;
	private ArrayList<InspectedMethod> methods;
	private ArrayList<InspectedField> fields;
	private ArrayList<InspectedConstructor<Constructor>> constructors;
	private ArrayList<InspectedClass> interfaces;
	private InspectedClass superClass;

	
	
	public InspectedClass(Class<?> obj) {
		
		setName(obj.getName());
			
		methods = new ArrayList<InspectedMethod>();
		for(Method m : obj.getDeclaredMethods()) {
			addMethod(new InspectedMethod(m));
		}
		fields = new ArrayList<InspectedField>();
		for(Field f : obj.getFields()) {
			addField(new InspectedField(f));
		}
		constructors = new ArrayList<InspectedConstructor<Constructor>>();
		for(Constructor<?> c : obj.getDeclaredConstructors()) {
			addConstructor(new InspectedConstructor<Constructor>(c));
		}
		interfaces = new ArrayList<InspectedClass>();
		for(Class<?> i : obj.getInterfaces()) {
			addInterface(new InspectedClass(i));
		}
		
		setSuper((obj.getSuperclass() == null) ? null 
				: new InspectedClass(obj.getSuperclass()));
		
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
			
	public void addMethod(InspectedMethod method) {
		methods.add(method);
	}
		
	public void addField(InspectedField field) {
		fields.add(field);
	}
	
	public void addConstructor(InspectedConstructor<Constructor> constructor) {
		constructors.add(constructor);
	}
	
	public void setSuper(InspectedClass superClass) {
		this.superClass = superClass;
	}
	
	public InspectedClass getSuper() {
		return superClass;
	}
	
	public void addInterface(InspectedClass obj) {
		interfaces.add(obj);
	}
	
	
	@Override
	public String toString() {

		return "\nName : " + getName() + 
				"\nMethods : " + methods +
				"\nFields : " + fields +
				"\nSuper Class :\n===============================" + getSuper() +
				"\nInterfaces : \n===============================" + interfaces;
	}
	
}
