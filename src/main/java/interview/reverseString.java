package interview;

/**
 * @author Ronchy
 *
 */
public class reverseString {
	public static String reverse(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }
	public static void main (String[] args){
		String a = reverse("HelloWorld");
		System.out.println(a);
		
	}
	
	
}
