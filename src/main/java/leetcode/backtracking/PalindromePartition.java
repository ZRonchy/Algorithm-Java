package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<List<String>>();
        partition(s, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, List<String> temp, List<List<String>> result){
        if(s.length() == 0)
            result.add(new ArrayList<>(temp));
        else{
            for(int i = 1; i <= s.length(); i++){
                String partialString = s.substring(0, i);
                if(!isPalindrome(partialString)) continue;
                temp.add(partialString);
                partition(s.substring(i, s.length()), temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int begin = 0, end = s.length() - 1;
        while(begin < end)
            if(s.charAt(begin++) != s.charAt(end--))
                return false;
        return true;
    }
}
