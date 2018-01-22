package leetcode.bit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Given an input file with four billion integers, provide an algorithm to generate an integer which is not contained in the file. Assume you have 1 GB of memory.
 FOLLOW UP
 What if you have only 10 MB of memory?

 Solution: There are a total of 2^32, or 4 billion, distinct integers possible.
 We have 1 GB of memory, or 8 billion bits.Thus, with 8 billion bits, we can map all
 possible integers to a distinct bit with the available memory. The logic is as follows:
 1. Create a bit vector (BV) of size 4 billion.
 2. Initialize BV with all 0’s
 3. Scan all numbers (num) from the file and write BV[num] = 1;
 4. Now scan again BV from 0th index
 5. Return the first index which has 0 value.
 */
public class BitVector {
    public static void main(String[] args) {
        int checker = 0;
        System.out.println( checker & (1 << 2));
    }
    private byte[] bitfield = new byte[0xFFFFFFF / 8];

    void findOpenNumber() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("input_file_q11_4.txt"));
        while (in.hasNextInt()) {
            int n = in.nextInt();
             /* Finds the corresponding number in the bitfield by using the
              * OR operator to set the nth bit of a byte (e.g.. 10 would
              * correspond to the 2nd bit of index 2 in the byte array). */
            bitfield[n / 8] |= 1 << (n % 8); //Set corresponding bit of index to 1\
        }

        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                 /* Retrieves the individual bits of each byte. When 0 bit
                  * is found, finds the corresponding value. */
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                    return;
                }
            }
        }
    }
}
