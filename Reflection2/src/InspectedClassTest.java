import static org.junit.Assert.*;
import java.lang.reflect.*;
import org.junit.Test;

public class InspectedClassTest {
	
	@Test
	public void testGetMethods() {
		
		ClassA exClass = new ClassA(1);
		Method[] methods = exClass.getClass().getDeclaredMethods();
		InspectedClass i = new InspectedClass(exClass.getClass());
		
		for(InspectedMethod im : i.getMethods()) {
			Method m1 = im.getMethod();
			boolean exists = false;
			
			for(Method m2 : methods) {
				if(m1.equals(m2)) {
					exists = true;
				}
			}
			
			assertTrue(exists);
		}	
	}
	
	@Test
	public void testGetFields() {
		ClassA exClass = new ClassA(1);
		Field[] fields = exClass.getClass().getDeclaredFields();
		
		InspectedClass i = new InspectedClass(exClass.getClass());
		
		for(InspectedField f : i.getFields()) {
			Field f1 = f.getField();
			boolean exists = false;
			
			for(Field f2 : fields) {
				if(f1.equals(f2)) {
					exists = true;
				}
			}
			
			assertTrue(exists);
		}	
		
		
		
	}
	
	@Test
	public void testGetConstructors() {
		
		ClassA exClass = new ClassA(1);
		Constructor[] constructors = exClass.getClass().getDeclaredConstructors();
		
		InspectedClass i = new InspectedClass(exClass.getClass());
		
		for(InspectedExecutable c : i.getConstructors()) {
			Constructor c1 = (Constructor)c.getExecutable();
			boolean exists = false;
			
			for(Constructor c2 : constructors) {
				if(c1.equals(c2)) {
					exists = true;
				}
			}
			
			assertTrue(exists);
		}	
		
		
		
		
	}
	
	
	@Test
	public void testGetInterfaces() {
		
		ClassA exClass = new ClassA(1);
		Class<?>[] interfaces = exClass.getClass().getInterfaces();
		
		InspectedClass i = new InspectedClass(exClass.getClass());
		
		for(InspectedClass c : i.getInterfaces()) {
			Class<?> c1 = c.getType();
			boolean exists = false;
			
			for(Class<?> c2 : interfaces) {
				if(c1.equals(c2)) {
					exists = true;
				}
			}
			
			assertTrue(exists);
		}		
	}
	
	@Test
	public void testGetSuperClass() {
		
		ClassA exClass = new ClassA(1);
		Class<?> superClass = exClass.getClass().getSuperclass();
		InspectedClass i = new InspectedClass(exClass.getClass());
		
		assertEquals(i.getSuperClass().getType(), superClass);	
	}
	
	@Test
	public void testHasSuperClassNoSuperClass() {
		assertFalse(new InspectedClass(Object.class).hasSuperClass());
	}
	
	@Test
	public void testHasSuperClass() {
		assertTrue(new InspectedClass(Integer.class).hasSuperClass());	
	}
	
	@Test
	public void testEqualOnEqualClasses() {
		assertEquals(new InspectedClass(Object.class), new InspectedClass(Object.class));
	}
	
	@Test
	public void testEqualOnUnequalClasses() {
		assertNotEquals(new InspectedClass(Object.class), new InspectedClass(Integer.class));
	}
	
	
}
