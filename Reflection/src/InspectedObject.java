

public class InspectedObject {

	private Class<?> classLevel;
	private Object baseObj;
	private boolean recursive;
	private InspectedObject parent;
	
	public static InspectedObject create(Object obj, boolean recursive) {
		Class<?> classObj = obj.getClass();
		if(classObj.isArray())
			return new InspectedArray(obj, recursive);
		
		else if(classObj.isPrimitive())
			return new InspectedPrimitive(obj);
		
		return new InspectedClass(obj, recursive);
	}
	
	public static InspectedObject create(InspectedObject parent, Object obj) {
		Class<?> classObj = obj.getClass();
		if(classObj.isArray())
			return new InspectedArray(parent, obj);
		
		if(classObj.isPrimitive())
			return new InspectedPrimitive(obj);
	
		if(parent.isReferenced(classObj)) {
			return new InspectedObject(parent, obj);
		}
		
		return new InspectedClass(parent, obj);	
	}

	
	public InspectedObject(Object baseObj, boolean recursive) {
		init(baseObj, baseObj.getClass(), null, recursive);
	}
	
	public InspectedObject(InspectedObject parent, Class<?> classLevel){
		init(parent.getBaseObject(), classLevel, parent, parent.isRecursive());
	}
	
	public InspectedObject(InspectedObject parent, Object obj) {
		init(obj, obj.getClass(), parent, parent.isRecursive());
	}
		
	private void init(Object obj, Class<?> classLevel, InspectedObject parent, boolean recursive) {
		baseObj = obj;
		this.classLevel = classLevel;
		this.parent = parent;
		this.recursive = recursive;
	}
		
	public Class<?> getClassLevel(){
		return classLevel;
	}
	
	public Object getBaseObject() {
		return baseObj;
	}
	
	public boolean isRecursive() {
		return recursive;
	}
	
	public boolean isReferenced(Class<?> type) {
		if(type.equals(classLevel))
			return true;
		if(parent == null) 
			return false;	
		return parent.isReferenced(type);
	}
			
	@Override
	public String toString() {
		return "Type : " + classLevel.getName();
	}
}
