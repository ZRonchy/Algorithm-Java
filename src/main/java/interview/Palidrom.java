package Programming;

public class Palidrom {
	private static String getLongestPalindrome(String string) {
	    String odd = getLongestPalindromeOdd(string);
	    String even = getLongestPalindromeEven(string);
	    return (odd.length() > even.length() ? odd : even);
	}

	public static String getLongestPalindromeOdd(final String input) {
	    int rightIndex = 0, leftIndex = 0;
	    String currentPalindrome = "", longestPalindrome = "";
	    for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
	        leftIndex = centerIndex;
	        rightIndex = centerIndex + 1;
	        while (leftIndex >= 0 && rightIndex < input.length()) {
	            if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
	                break;
	            }
	            currentPalindrome = input.substring(leftIndex, rightIndex + 1);
	            longestPalindrome = currentPalindrome.length() > longestPalindrome
	                    .length() ? currentPalindrome : longestPalindrome;
	            leftIndex--;
	            rightIndex++;
	        }
	    }
	    return longestPalindrome;
	}

	public static String getLongestPalindromeEven(final String input) {
	    int rightIndex = 0, leftIndex = 0;
	    String currentPalindrome = "", longestPalindrome = "";
	    for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
	        leftIndex = centerIndex - 1;
	        rightIndex = centerIndex + 1;
	        while (leftIndex >= 0 && rightIndex < input.length()) {
	            if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
	                break;
	            }
	            currentPalindrome = input.substring(leftIndex, rightIndex + 1);
	            longestPalindrome = currentPalindrome.length() > longestPalindrome
	                    .length() ? currentPalindrome : longestPalindrome;
	            leftIndex--;
	            rightIndex++;
	        }
	    }
	    return longestPalindrome;
	}
	
	
	
	public static void main(String[] args){
		String s = getLongestPalindrome("HYTBCABADEFGHABCDEDCBAGHTFYW12345678987654321ZWETYGE");
		System.out.println(s);
	}
	
}
