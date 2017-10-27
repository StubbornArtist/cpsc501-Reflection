		
public class InspectedPrimitive extends InspectedBaseObject{
	
	public InspectedPrimitive(Object obj){
		super(obj, false);
	}

	public String toString(){
		
		return "Type : "+ getType().getName() +
		"\nValue : " + getBase();
	}
}
