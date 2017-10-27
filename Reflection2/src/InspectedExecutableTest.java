import org.junit.*;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

public class InspectedExecutableTest {
	
	@Test
	public void testToString() {
		try {
			Method m = Object.class.getMethod("toString", null);
			InspectedExecutable ei = new InspectedExecutable(m);
			
			assertEquals(ei.toString(), "Name : toString\nModifiers : public" );
		}
		catch(NoSuchMethodException e) {}	
		
	}
	
	@Test
	public void testToStringWithParameters() {
		try {
			Method m = Object.class.getMethod("wait", new Class<?>[]{long.class});
			InspectedExecutable ei = new InspectedExecutable(m);
			
			
			assertEquals(ei.toString(), "Name : wait\nModifiers : public final native\nParameters : [long]" );
		}
		catch(NoSuchMethodException e) {}		
	}

}
