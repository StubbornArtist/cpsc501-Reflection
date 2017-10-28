import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class InspectedArrayTest {
	
	@Test
	public void testGetMembersNullObjects() {
		InspectedArray arr = new InspectedArray(new Object[2], false);
		
		ArrayList<InspectedBaseObject> members = arr.getMembers();
		
		for(InspectedBaseObject member : members) {
			assertEquals(member, null);
		}
	}
	
	@Test
	public void testGetMembers() {
		Object [] objs = new Object [] {new Integer(2), 3};
		InspectedArray arr = new InspectedArray(objs, false);
		ArrayList<InspectedBaseObject> members = arr.getMembers();
		
		assertEquals(members.size(), objs.length);
		
		for(int i = 0; i < members.size(); i++) {
			assertEquals(members.get(i).getBase(), objs[i]);
		}
	}
}
