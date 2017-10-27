import org.junit.*;
import static org.junit.Assert.*;

public class StringExtensionsTest {
	
	@Test
	public void testIndent() {
		assertEquals(StringExtensions.indent("Hi"), "\tHi");
	}
	
	@Test
	public void testIndentMoreThanOnce() {
		
		assertEquals(StringExtensions.indent("Hi", 2), "\t\tHi");
	}
	
	@Test
	public void testIndentZeroTimes() {
		
		assertEquals(StringExtensions.indent("Hi", 0), "Hi");
	}

}
