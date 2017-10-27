
public class StringExtensions {
	
	public static String indent(String str, int depth) {
		return str.replaceAll("(?m)^", repeat("\t", depth)); 
	}
	
	public static String indent(String str) {
		return indent(str, 1);
	}
	
	public static String repeat(String str, int num) {
		String result = "";
		for(int i = 0; i < num; i++) {
			result += str;
		}
		return result;
	}

}
