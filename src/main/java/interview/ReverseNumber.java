package Programming;

public class ReverseNumber {

    public static void main(String args[]) {

        System.out.println("Reverse of number is " + reverse(1234));   
    
    }
  
    /*
     * reverse a number in Java using iteration
     * @return reverse of number
     */
    public static int reverse(int number){
        int reverse = 0;
        int remainder = 0;
        do{
            remainder = number%10;
            reverse = reverse*10 + remainder;
            number = number/10;
          
        }while(number > 0);
      
        return reverse;
    }

}

