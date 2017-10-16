package leetcode.bit;

// Given an array of integers, every element appears twice except for one.
// Find that single one.
// Your algorithm should have a linear runtime complexity.
// Could you implement it without using extra memory?


//1. a ^ b = b ^ a
//2. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c;

public class SingleNumber {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 2, 1, 5};
        System.out.print(singleNumber(A));
    }

    public static int singleNumber(int[] A) {
        int result = A[0];
        for(int i = 1; i < A.length; i++) {
            System.out.println("result: "+result+"; A[i]: "+ A[i]+"; result^A[i]: "+(result^A[i]));
            result = result ^ A[i];
        }
        return result;
    }
}
