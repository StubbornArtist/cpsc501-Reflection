import org.junit.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class InspectedObjectTest {
	
	@Test
	public void testGetFields() {
		InspectedObject obj = new InspectedObject(new Integer(3), false);	
		HashMap<String, InspectedBaseObject> iFields = obj.getFields();
		Field [] fields = Integer.class.getDeclaredFields();
		
		assertEquals(iFields.size(),fields.length);
		
		for(Field f : fields) {
			assertTrue(iFields.containsKey(f.getName()));			
		}
	}
	
	@Test
	public void testGetInterfaces() {
		InspectedObject obj = new InspectedObject(new Integer(3), false);
		ArrayList<InspectedBaseObject> iInterfaces = obj.getInterfaces();
		Class<?> [] interfaces = Integer.class.getInterfaces();
		
		assertEquals(iInterfaces.size(), interfaces.length);
		
		for(Class<?> i1 : interfaces) {
			boolean exists = false;
			for(InspectedBaseObject i2 : iInterfaces) {
				if(i2.getType().getName().equals(i1.getName())) {
					exists = true;
				}
				assertTrue(exists);
			}
			
			
		}	
	}
	
	
	@Test
	public void testGetSuperClass() {
		InspectedObject obj = new InspectedObject(new Integer(3), false);
		InspectedBaseObject iSuperClass = obj.getSuperClass();
		Class<?> superClass = Integer.class.getSuperclass();
		
		assertEquals(superClass.getName(),iSuperClass.getType().getName());	
	}

}
