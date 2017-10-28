import java.util.HashMap;

public class InspectedPrimitive extends InspectedBaseObject{
	
	public final static HashMap<Class<?>, Class<?>> primitiveMap = new HashMap<Class<?>, Class<?>>();
	static {
		primitiveMap.put(Integer.class, int.class);
		primitiveMap.put(Double.class, double.class);
		primitiveMap.put(Long.class, long.class);
		primitiveMap.put(Float.class, float.class);
		primitiveMap.put(Short.class, short.class);
		primitiveMap.put(Byte.class, byte.class);
		primitiveMap.put(Character.class, char.class);
		primitiveMap.put(Boolean.class, boolean.class);
		
	}
	
	private Class<?> primitiveType;
	
	public InspectedPrimitive(Object obj){
		super(obj, false);
		
		primitiveType = unwrap(obj.getClass());
	}
	
	public Class<?> unwrap(Class<?> wrapperClass){
		if(primitiveMap.containsKey(wrapperClass)) {
			return primitiveMap.get(wrapperClass);
		}
		return wrapperClass;
	}

	public String toString(){
		
		return "Type : "+ primitiveType.getName() +
		"\nValue : " + getBase();
	}
}
