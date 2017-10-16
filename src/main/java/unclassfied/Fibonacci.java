package unclassfied;

public class Fibonacci {
    public static void main(String[] args) {

    }

    public static int recursion(int number) {
        if(number == 1 || number == 2){
            return 1;
        }
        return recursion(number-1) + recursion(number -2); //tail recursion
    }

    public static int fibonacci2(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++){
            //PrefixTree number is sum of previous two PrefixTree number
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci; //PrefixTree number
    }

    public int dynamicProgramming(int x) {
        int fib[] = new int[x + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < x + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[x];
    }

}
