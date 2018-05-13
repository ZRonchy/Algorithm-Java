package leetcode.stringarray;

import java.util.ArrayList;
import java.util.List;

public class FindAllPalindromePartition {
    static boolean isPalindrome(String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    static void allPalindromePartition(List<List<String>> allPart,
                                      List<String> currentPart,
                                      int start,
                                      int n,
                                      String str) {
        if (start >= n){
            allPart.add(currentPart);
        }

        // Pick all possible ending points for substrings
        for (int i=start; i<n;i++) {
            // If substring str[start..i] is palindrome
            if (isPalindrome(str, start, i)) {
                currentPart.add(str.substring(start, i));
            }

            allPalindromePartition(allPart, currentPart, i+1, n, str);

            currentPart.remove(currentPart.size() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "nitin";
        List<List<String>> allResults = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        allPalindromePartition(allResults, currentPartition, 0, str.length(), str);
        System.out.println(allResults);
    }
}
