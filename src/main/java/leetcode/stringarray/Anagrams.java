package leetcode.stringarray;

// Given an array of strings, return all groups of strings that are anagrams.
// Note: All inputs will be in lower-case.
// An anagram is direct word switch or word play, the result of rearranging
// the letters of a word or phrase to produce a new word or phrase,
// using all the original letters exactly once; for example,

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        String[] A = {"tea","and","ate","eat","den"};
        System.out.print(groupAnagrams(A));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String ns = new String(arr);

            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }

    // It creates a size 26 int arrays as buckets for each letter in alphabet.
    // It increments the bucket value with String s and decrement with string t.
    // So if they are anagrams, all buckets should remain with initial value which is zero.
    // So just checking that and return
    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
