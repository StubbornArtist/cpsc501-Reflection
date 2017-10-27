import org.junit.*;
import static org.junit.Assert.*;

public class InspectedBaseObjectTest {

	
	@Test
	public void testCreateFromObject() {		
		InspectedBaseObject obj = InspectedBaseObject.create(new Object(), false);		
		assertEquals(obj.getClass(), InspectedObject.class);
			
	}
	
	
	@Test
	public void testCreateFromPrimitive() {	
		
		InspectedBaseObject obj = InspectedBaseObject.create(1, false);		
		assertEquals(obj.getClass(), InspectedPrimitive.class);
			
	}
	
	
	@Test
	public void testCreateFromArray() {
		InspectedBaseObject obj = InspectedBaseObject.create(new int [] {}, false);
		assertEquals(obj.getClass(), InspectedArray.class);
			
	}
	
	
	@Test
	public void testHasReferenceNoReference() {
		
		InspectedBaseObject obj = InspectedBaseObject.create(new Object(), false);
		boolean exists = obj.hasReference(new InspectedClass(Integer.class));
		assertTrue(!exists);
		
		
	}
	
	@Test
	public void testHasReferenceSelf() {
		
		InspectedBaseObject obj = InspectedBaseObject.create(new Integer(1), false);
		boolean exists = obj.hasReference(new InspectedClass(Integer.class));
		assertTrue(exists);
		
	}
			
}
