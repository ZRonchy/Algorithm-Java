package leetcode.stringarray;

// There are n stairs, each time one can climb 1 or 2. How many different ways to climb the stairs?
public class StairClimbing {

    private static int f(int n) {
        if(n <= 2) {
            return n;
        }
        return f(n-2) + f(n-1);
    }

    private static int f1(int n) {
        if(n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int third = 0;

        for(int i=3; i<=n; i++) {
            third = first + second;
            second = third;
            first = second;
        }
        return third;
    }

//    dynamic programming
    private static int[] A = new int[100];
    private static int f3(int n) {
        if(n <= 2) {
            return n;
        }

        if(A[n] > 0) {
            return A[n];
        }

        A[n] = f3(n-1) + f3(n-2);
        return A[n];
    }
}
