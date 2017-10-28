import org.junit.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;


public class InspectedFieldTest {
	
	
	@Test
	public void testGetObjectExistingField() {
		
		ClassA exClass = new ClassA(2);
		try {
			Field f = exClass.getClass().getDeclaredField("val");
			InspectedField fi = new InspectedField(f);
			
			assertEquals(fi.getObject(exClass), f.get(exClass));
			
		}
		catch(NoSuchFieldException e) {
			fail();
		}
		catch(IllegalAccessException e) {
			fail();
		}
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetObjectWrongObject() {
		
		ClassA exClass = new ClassA(2);
		ClassD exClass2 = new ClassD();
		try {
			Field f = exClass.getClass().getDeclaredField("val");
			InspectedField fi = new InspectedField(f);
			
			fi.getObject(exClass2);			
		}
		catch(NoSuchFieldException e) {
			
			fail();
		}
		
	}
	
	@Test
	public void testEqualsEqualFields() {
		try {
			Field f1 = Integer.class.getDeclaredField("MAX_VALUE");
			Field f2 = Integer.class.getDeclaredField("MAX_VALUE");
			assertEquals(new InspectedField(f1), new InspectedField(f2));
		}
		catch(NoSuchFieldException e) {
			
			fail();
		}
		
	}
	
	@Test
	public void testEqualsUnequalFields() {
		try {
			Field f1 = Integer.class.getDeclaredField("MAX_VALUE");
			Field f2 = Integer.class.getDeclaredField("MIN_VALUE");
			assertNotEquals(new InspectedField(f1), new InspectedField(f2));
		}
		catch(NoSuchFieldException e) {
			fail();
		}
		
	}
	
	

}
