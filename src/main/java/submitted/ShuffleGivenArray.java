package submitted;

import java.util.Arrays;
import java.util.Random;

/**
 * The idea is to start from the last element, swap it with a randomly selected
 * element from the whole array (including last). Now consider the array from 0
 * to n-2 (size reduced by 1), and repeat the process till we hit the first element.
 */
public class ShuffleGivenArray {
    //A Function to generate a random permutation of arr[]
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

    // A Function to generate a random permutation of arr[]
    static void randomize(int arr[], int n) {
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = r.nextInt(i + 1);

            // Swap arr[i] with the element at random index
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // Prints the random array
        System.out.println(Arrays.toString(arr));
    }
}
