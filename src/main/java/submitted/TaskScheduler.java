package submitted;

import java.util.Arrays;

/**
 * https://leetcode.com/submissions/detail/183286096/
 * Greedy algorithm. Always choose the most frequent task to calculate frame size
 */
public class TaskScheduler {
    // (c[25] - 1) * (n + 1) + 25 - i  is frame size
    // when inserting chars, the frame might be "burst", then tasks.length takes precedence
    // when 25 - i > n, the frame is already full at construction, the following is still valid.
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
