import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class InspectedClass extends InspectedObject{

	private ArrayList<InspectedMethod> methods;
	private ArrayList<InspectedField> fields;
	private ArrayList<InspectedObject> interfaces;
	private ArrayList<InspectedExecutable> constructors;
	private InspectedObject superClass;

	public InspectedClass(Object baseObj, boolean recursive) {
		super(baseObj, recursive);
		init();
	}
	
	public InspectedClass(InspectedClass parent, Class<?> classLevel) {
		super(parent, classLevel);
		init();
	}
	
	public InspectedClass(InspectedObject parent, Object obj) {
		super(parent, obj);
		init();
	}
	
	private void init() {
		
		Class<?> level = getClassLevel();
		interfaces = new ArrayList<InspectedObject>();
		for(Class<?> i : level.getInterfaces()) {
			if(!isReferenced(i)) {
				interfaces.add(new InspectedClass(this, i));
			}
			else {
				interfaces.add(new InspectedObject(this, i));
			}	
		}
		
		Class<?> superDef = level.getSuperclass();
		if(!(superDef == null)) {
			if(!isReferenced(superDef)) {
				superClass = new InspectedClass(this, superDef);
			}
			else {
				superClass = new InspectedObject(this, superDef);
			}
		}	
			
		fields = new ArrayList<InspectedField>();
		for(Field f : level.getDeclaredFields()) {
			fields.add(new InspectedField(f, this));
		}
		
		methods = new ArrayList<InspectedMethod>();
		for(Method m : level.getDeclaredMethods()) {
			methods.add(new InspectedMethod(m));
		}
		
		constructors = new ArrayList<InspectedExecutable>();
		for(Constructor<?> c : level.getDeclaredConstructors()) {
			constructors.add(new InspectedExecutable(c));
		}
		
	}
		
	private <T extends Object> String membersToString(ArrayList<T> members) {
		String result ="\n\n";
		
		for(Object o : members) {
			result += StringExtensions.indent(o.toString()) + "\n\n";
			
		}
		return result;
	}
		
	@Override
	public String toString() {
		
		String result = super.toString();
		if(!fields.isEmpty())
			result += "\nFields : " + membersToString(fields); 
		if(!methods.isEmpty())
			result += "\nMethods : " + membersToString(methods);
		if(!constructors.isEmpty())
			result += "\nConstructors : " + membersToString(constructors);
		if(!interfaces.isEmpty())
			result += "\nInterfaces : " + membersToString(interfaces);
		if(superClass != null) 
			result += "\nSuper Class : \n" + StringExtensions.indent(superClass.toString());
			
		return result;
	}

	
}
