public class Inspector {
	
	
	public void inspect(Object obj, boolean recursive) {
		
		InspectedBaseObject result = InspectedBaseObject.create(obj, recursive);
		System.out.println(result);
		
	}
	
}
