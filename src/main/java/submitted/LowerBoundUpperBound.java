package submitted;

public class LowerBoundUpperBound {
    // first index of i such that A[i] > x
    static int upperBound(int[] A, int val, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] > val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l; // l is the smallest possible index that satisfy A[mid] > val
    }

    // first index of i such that A[i] > x
    static int lowerBound(int[] A, int val, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] >= val) {
                r = mid - 1;
            } else {
                l = mid + 1; // l is the smallest possible index that satisfy A[mid] >= val
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 2, 4, 4, 5};
        System.out.println("lower bound " + lowerBound(A, 3, 0, A.length - 1));
        System.out.println("upper bound " + upperBound(A, 5, 0, A.length - 1));
    }
}
