package Programming;

public class reverseNum {
	
    public static void main(String args[]) {

        for(int i=1; i<=12; i++){
            System.out.print(Fib(i) +" ");
        }
    }
	
   public static int Fib(int number){
	   if (number == 1 || number ==2)
		   return 1;
	   else return Fib(number-1)+Fib(number-2);

   }
}
