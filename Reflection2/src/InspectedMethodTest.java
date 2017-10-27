import org.junit.*;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

public class InspectedMethodTest {

	
	@Test
	public void testToStringNoExceptions() {
		
		try {
			Method m = Object.class.getMethod("equals", new Class<?>[]{Object.class});
			InspectedMethod mi = new InspectedMethod(m);
			
			assertEquals(mi.toString(), "Name : equals\nModifiers : public\nParameters : [java.lang.Object]\nReturn Type : boolean" );
		}
		catch(NoSuchMethodException e) {}
			
	}
	
	@Test
	public void testToStringWithExceptions() {
		
		try {
			Method m = Object.class.getMethod("wait", new Class<?>[]{long.class});
			InspectedMethod mi = new InspectedMethod(m);
			
			assertEquals(mi.toString(), "Name : wait\nModifiers : public final native\nParameters : [long]\nReturn Type : void\nExceptions : [java.lang.InterruptedException]" );
		}
		catch(NoSuchMethodException e) {}
		
		
		
	}
}
