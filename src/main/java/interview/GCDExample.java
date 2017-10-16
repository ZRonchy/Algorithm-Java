package interview;

/**
 * Java program to demonstrate How to find Greatest Common Divisor or GCD of 
 * two numbers using Euclid��s method. There are other methods as well to 
 * find GCD of two number in Java but this example of finding GCD of two number
 * is most simple.
 *
 * @author Javin Paul
 */
public class GCDExample {
  
  
    public static void main(String args[]){
     
      
        System.out.println("GCD of two numbers is :" + findGCD(15,9));
      
      
    }

    /*
     * Java method to find GCD of two number using Euclid's method
     * @return GDC of two numbers in Java
     */
    private static int findGCD(int number1, int number2) {
        //base case
        if(number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
    }
}
