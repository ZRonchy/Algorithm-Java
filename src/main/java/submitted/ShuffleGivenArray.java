package submitted;

import java.util.Random;

/**
 * The idea is to start from the last element, swap it with a randomly selected
 * element from the whole array (including last). Now consider the array from 0
 * to n-2 (size reduced by 1), and repeat the process till we hit the first element.
 */
public class ShuffleGivenArray {
    public void shuffle(int card[], int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            // Random for remaining positions.
            int r = i + rand.nextInt(52 - i);

            //swapping the elements
            int temp = card[r];
            card[r] = card[i];
            card[i] = temp;

        }
    }
}
