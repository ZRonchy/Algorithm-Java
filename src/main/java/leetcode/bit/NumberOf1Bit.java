package leetcode.bit;

// Write a function that takes an unsigned integer
// and returns the number of ’1' bits it has (also known as the Hamming weight).

public class NumberOf1Bit {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=1; i<33; i++){
            if(getBit(n, i)){
                count++;
            }
        }
        return count;
    }

    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }
}
