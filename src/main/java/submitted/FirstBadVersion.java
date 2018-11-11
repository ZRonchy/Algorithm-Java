package submitted;

/**
 * https://leetcode.com/submissions/detail/188940580/
 * Binary Search
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int first = 1, last = n;
        while (first <=  last) {
            int middle = first + (last-first)/2;

            if (isBadVersion(middle)) {
                if (middle == 1) {
                    return 1;
                }
                if (!isBadVersion(middle-1)) {
                    return middle;
                } else {
                    last = middle -1 ;
                }

            } else {
                first = middle + 1;
            }
        }
        return -1;
    }

    boolean isBadVersion(int n) {
        return false;
    }
}
