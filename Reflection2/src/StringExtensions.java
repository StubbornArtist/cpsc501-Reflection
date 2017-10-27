import java.util.ArrayList;
import java.util.Collection;

public class StringExtensions {
	
	public static String indent(String str, int depth) {
		return str.replaceAll("(?m)^", repeat("\t", depth)); 
	}
	
	public static String indent(String str) {
		return indent(str, 1);
	}
	
	private static String repeat(String str, int num) {
		String result = "";
		for(int i = 0; i < num; i++) {
			result += str;
		}
		return result;
	}
	
	public static <T extends Object> String lineSeperatedString(Collection<T> list){
		if(list.isEmpty()) return "";
		
		String result ="\n\n";
		
		for(T ele : list) {
			result += ((ele == null)? "null" : ele.toString()) + "\n\n";	
		}
		return result;
		
	}

}
