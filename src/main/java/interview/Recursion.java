package Programming;

public class Recursion {
	static void fun1(int n)
	{
	   int i = 0;  
	   if (n > 1)
	     fun1(n-1);
	   for (i = 0; i < n; i++)
	     System.out.println(" * ");
	}
	
	static int LIMIT=1000;
	static void fun2(int n)
	{
	  if (n <= 0)
	     return;
	  if (n > LIMIT)
	    return;
	  System.out.println(n);
	  fun2(2*n);
	  System.out.println(n);
	} 
	
	
    public static void main(String args[]) {
      fun2(3);
      fun1(6);
    } 
	
	
	
}
