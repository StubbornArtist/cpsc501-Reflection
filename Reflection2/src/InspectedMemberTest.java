import org.junit.*;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class InspectedMemberTest {
	
	@Test
	public void testToStringNoParameterTypes() {
		try {
			Method m = Object.class.getMethod("toString", null);
			InspectedMember mi = new InspectedMember(m);
			
			assertEquals(mi.toString(), "Name : toString\nModifiers : public");
		}
		catch(NoSuchMethodException e) {}	
	}

}
