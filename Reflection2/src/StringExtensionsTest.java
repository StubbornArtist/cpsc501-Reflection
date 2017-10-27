import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

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
	
	@Test
	public void testLineSeperatedString() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("E1");
		strings.add("E2");
		strings.add("E3");
		
		assertEquals(StringExtensions.lineSeperatedString(strings), "\n\nE1\n\nE2\n\nE3\n\n");
	}
	
	@Test
	public void testLineSeperatedStringWithNulls() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("E1");
		strings.add("E2");
		strings.add(null);
		
		assertEquals(StringExtensions.lineSeperatedString(strings), "\n\nE1\n\nE2\n\nnull\n\n");	
	}
	
	@Test
	public void testLineSeperatedStringEmptyCollection() {
		ArrayList<String> strings = new ArrayList<String>();		
		assertEquals(StringExtensions.lineSeperatedString(strings), "");	
	}
	
	

}
