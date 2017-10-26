public class Inspector {
	
	
	public void inspect(Object obj, boolean recursive) {
		
		InspectedObject result = InspectedObject.create(obj, recursive);
		System.out.println(result);
		
	}
	
}
