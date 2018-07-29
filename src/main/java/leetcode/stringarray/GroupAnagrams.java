package leetcode.stringarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * If two strings are anagram to each other, their sorted sequence is the same.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
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
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }
}
