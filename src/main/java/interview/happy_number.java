package Code;
import java.util.HashMap;
public class happy_number {
    
    public static void main(String args[]) {

        if(isHappyNumber(13)){
            System.out.println("Number is a happy number");
        }else{
            System.out.println("Number is not a happy number");
        }

    
    }
	
	
    static HashMap<Integer,Integer> map =new HashMap<Integer,Integer>(); 
    
	public static boolean isHappyNumber(int number){

		
		while(true){
			int result=0;
			int remainder=0;
			while (number!=0){
				remainder=number%10;
				result+=remainder*remainder;
				number=number/10;
				
			}
			
			if (map.containsKey(new Integer(result)))
				return false;
			map.put(new Integer(result),new Integer(result));
			if (result==1)
				return true;
			number=result;
			//else return isHappyNumber(result);
			
			for (Integer key : map.keySet()) {
			    Integer value = map.get(key);
			    System.out.println("Key = " + key + ", Value = " + value);
			}
			
		}
		

		
		
	}
	
	
}
