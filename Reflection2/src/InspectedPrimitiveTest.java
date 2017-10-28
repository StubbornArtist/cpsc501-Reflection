import org.junit.*;
import static org.junit.Assert.*;

public class InspectedPrimitiveTest {
	
	@Test
	public void testUnwrapPrimitive() {
		Integer obj = new Integer(2);
		InspectedPrimitive prim = new InspectedPrimitive(obj);
		assertEquals(prim.getPrimitiveType(), int.class);
	}
	
	@Test
	public void testUnwrapObject() {
		Object obj = new Object();
		InspectedPrimitive prim = new InspectedPrimitive(obj);
		assertEquals(prim.getPrimitiveType(), Object.class);
	}

}
