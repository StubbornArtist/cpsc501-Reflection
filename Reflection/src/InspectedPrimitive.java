
public class InspectedPrimitive extends InspectedObject {
		
	public InspectedPrimitive (Object obj) {		
		super(obj, false);
	}
	
	public String toString() {
		return super.toString() +
				"Value : " + getBaseObject();
	}
}
