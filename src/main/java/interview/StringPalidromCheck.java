package Programming;

public class StringPalidromCheck {
		   public static void main(String args[])
		   {
            
		 
		      if (stringCheck("aollo"))
		         System.out.println("Entered string is a palindrome.");
		      else
		         System.out.println("Entered string is not a palindrome.");
		 
		   }

static boolean stringCheck(String s){
	String tem="";
	for (int i=s.length()-1;i>=0;i--){
		tem+=s.charAt(i);
		
	}
	if (tem.equals(s)){
		return true;
	}
	return false;
	
	
}


}