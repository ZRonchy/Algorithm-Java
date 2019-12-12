package interview;

public class Q_subString {
	public static void main (String [] args){
	System.out.println(issubString2( "ing", "iasing"));
}

	
public static boolean isSubstring(String s1, String s2){
	if (s1.length() < s2.length()){
	 
		for (int a=0; a< s2.length()-s1.length()+1; a++){
			if (s1.equals(s2.substring(a, a+s1.length()))){
				return true;
			}
		}
	}
	else{
		for (int a=0; a< s1.length()-s2.length()+1; a++){
			if (s2.equals(s1.substring(a, a+s2.length()))){
				return true;
				
			}
		}
	}
	 
	   return false;
	
  }

public static boolean isSubstring1(String s1, String s2){
	int count=1;
    int offset=s2.length();
	for (int i=0;i<s2.length();i++){
		if (s2.charAt(i)==s1.charAt(0)){
			
			if (offset-i<s1.length())
				return false;
			int k=1;
			for (int j=i+1; j<i+s1.length();j++){
				if(s2.charAt(j)==s1.charAt(k)){
					count++;
					k++;
				}
			}
			if(count==s1.length()) return true;	
			else count=1;
		}
		
	}
	
	return false;
}
  
public static boolean issubString2(String s1, String s2){
	if (s1.length()>s2.length()) return false;
	
	for (int i=0;i<s2.length();i++){
		int count=1;
		int k=1;
		if (s2.charAt(i)==s1.charAt(0)){
			if (i+s1.length()>s2.length())
			   return false;
			for(int j=i+1;j<i+s1.length();j++){
				if (s2.charAt(j)==s1.charAt(k)){
					count++;
					k++;
				}
			}
			if(count==s1.length()){
				System.out.println(i);
				return true;}
			
		}
		
	}
	return false;
	
}



}

/*public String substring(int beginIndex, int endIndex)
返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，
直到索引 endIndex - 1 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。 */
