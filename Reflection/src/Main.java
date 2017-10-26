

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		ClassB b;
			try {
				b = new ClassB();
				
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			Inspector inspector = new Inspector();
			inspector.inspect(b, true);
	}
	
}


