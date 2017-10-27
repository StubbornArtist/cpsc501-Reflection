		
public class InspectedPrimitive extends InspectedBaseObject{
	
	public InspectedPrimitive(Object obj){
		super(null, obj);
	}

	public String toString(){
		
		return super.toString() +
		"\nValue : " + getBase();
	}
}
