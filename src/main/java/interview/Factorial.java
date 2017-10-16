package interview;

public class Factorial {
	public static void main(String[] args){
		System.out.println(Factorial(5));
	}
	
	public static long Factorial(long number)
	{
	    // base condition - if the number is 0 or 1, return 1
	    if (number <= 1)
	        return 1;
	    else
	    {
	        // recursive call to get the factorial again
	        return number * Factorial(number - 1);
	    }
	}
}
