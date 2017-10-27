
public class InspectedBaseObject {

	private InspectedClass type;
	private Object base;
	private InspectedBaseObject parent;
	private boolean recursive;
	
	public InspectedBaseObject(Object obj, boolean recursive){
		type = new InspectedClass(obj.getClass());
		base = obj;
		parent = null;
		this.recursive = recursive;
	}
		
	public InspectedBaseObject(InspectedBaseObject parent, InspectedClass type){
		this.type = type;
		base = parent.getBase();
		this.parent = parent; 
		this.recursive = parent.isRecursive();
	}
	
	public InspectedBaseObject(InspectedBaseObject parent, Object obj) {
		this.type = new InspectedClass(obj.getClass());
		base = obj;
		this.parent = parent;
		this.recursive = parent.isRecursive();
	}
	
	
	
	public static InspectedBaseObject create(InspectedBaseObject parent, InspectedClass type){
		if(!(parent == null) && parent.hasReference(type)){
			return new InspectedBaseObject(parent, type);
		}
		
		return new InspectedObject(parent, type);
	}
	
	
	
	public static InspectedBaseObject create(InspectedBaseObject parent, Object obj){
		
		if(obj == null) return null;
		
		Class<?> objClass = obj.getClass();
		
		if(objClass.isArray()){
			return new InspectedArray(parent, obj);
		}
			
		if(!parent.isRecursive() || objClass.isPrimitive() 
				|| parent.hasReference(new InspectedClass(objClass))){
			return new InspectedPrimitive(obj);
		}		
		return new InspectedObject(parent, obj);
	}
	
	
	public static InspectedBaseObject create(Object obj, boolean recursive) {
		Class<?> objClass = obj.getClass();
		if(objClass.isArray()) {
			return new InspectedArray(obj, recursive);
		}
		
		if(objClass.isPrimitive()) {
			return new InspectedPrimitive(obj);
		}
		
		return new InspectedObject(obj, recursive);
	}
	
	
	
	public Object getBase(){
		
		return base;
	}
	
	public InspectedClass getType(){
		
		return type;
		
	}
	
	public InspectedBaseObject getParent(){
	
		return parent;
	}
	
	public boolean isRecursive() {
		return recursive;
	}
	
	public boolean hasReference(InspectedClass type){
		if(this.type.equals(type)) return true;
		
		if(parent == null) return false;
		
		return parent.hasReference(type);
	}

	@Override
	public String toString(){
		return type.toString();
	}
	
	
	
	
}
