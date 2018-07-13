package leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings A and B. Minimize the number of unique characters
 * in string A by either swapping A[i] with B[i] or keeping it unchanged.
 * The number of swaps can be greater than or equal to 0. Note that A[i]
 * can be swapped only with same index element in B. Print the minimum number
 * of unique characters. Constraints: 0 < length of A ≤ 15.

 Examples:

 Input : A = ababa
 B = babab
 Output : 1
 Swapping all b's in string A, with
 a's in string B results in string
 A having all characters as a.

 Input : A = abaaa
 B = bbabb
 Output : 2
 Initially string A has 2 unique characters. Swapping at any index does not change this count.

 Approach: The problem can be solved using backtracking. Create a map in which key is A[i]
 and value is count of corresponding character. The size of the map tells the number of distinct
 characters as only those elements which are present in string A are present as key in map. At
 every index position, there are two choices: either swap A[i] with B[i] or keep A[i] unchanged.
 Start from index 0 and do following for each index:

 Keep A[i] unchanged, increment count of A[i] by one in map and call recursively for next index.
 Backtrack by decreasing count of A[i] by one, swap A[i] with B[i], increment count of A[i] by
 one in map and again recursively call for next index.
 */
public class MinUniqueCharsBySwapping {
    // Utility function to find minimum
// number of unique characters in string.
    public static void minCountUtil(String A, String B,
                      Map<String, Integer> ele,
                      int ans, int ind)
    {

        // If entire string is traversed, then
        // compare current number of distinct
        // characters in A with overall minimum.
        if (ind == A.length()) {
            ans = Math.min(ans, ele.size());
            return;
        }

        // swap A[i] with B[i], increase count of
        // corresponding character in map and call
        // recursively for next index.
        swap(A.charAt(ind), B.charAt(ind));
        ele[A[ind]]++;
        minCountUtil(A, B, ele, ans, ind + 1);

        // Backtrack (Undo the changes done)
        ele[A[ind]]--;

        // If count of character is reduced to zero,
        // then that character is not present in A.
        // So remove that character from map.
        if (ele[A[ind]] == 0)
            ele.remove(A[ind]);


        // Restore A to original form.
        // (Backtracking step)
        swap(A[ind], B[ind]);

        // Increase count of A[i] in map and
        // call recursively for next index.
        ele[A[ind]]++;
        minCountUtil(A, B, ele, ans, ind + 1);

        // Restore the changes done
        // (Backtracking step)
        ele[A[ind]]--;
        if (ele[A[ind]] == 0)
            ele.erase(A[ind]);
    }

    // Function to find minimum number of
    // distinct characters in string.
    public static int minCount(String A, String B) {
        // Variable to store minimum number
        // of distinct character.
        // Initialize it with length of A
        // as maximum possible value is
        // length of A.
        int ans = A.length();

        // Map to store count of distinct
        // characters in A. To keep
        // complexity of insert operation
        // constant unordered_map is used.
        Map<String, Integer> ele = new HashMap<>();

        // Call utility function to find
        // minimum number of unique
        // characters.
        minCountUtil(A, B, ele, ans, 0);

        return ans;
    }

    public static void main(String[] args) {
        String A = "abaaa";
        String B = "bbabb";

        System.out.println(minCount(A, B));
    }
}
