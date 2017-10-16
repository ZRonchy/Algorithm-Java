package Programming;

public class RemoveChar {

	public static void main(String[] args){
		System.out.println(removechar("Hello",'e'));
	}
	
	public static String removechar(String s, char c){
		String replace ="";
		char temp;
		for (int i=0; i<s.length();i++){
			temp = s.charAt(i);
			if (c==s.charAt(i))
				continue;
			
		replace += temp;		
		}
		return replace;
		
		
	}
	
}
