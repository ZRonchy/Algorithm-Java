package crackinginterview.moderate;

public class SwapTwoNumbers {

    public static void swap(int a, int b) {
        a = b - a;
        b = b - a;
        a = a + b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void swap_bit (int a, int b) {
        a = a ^ b;
        b = a ^ b; // b = a ^ b ^ b = a
        a = a ^ b; // a = a ^ b ^ a = b

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
