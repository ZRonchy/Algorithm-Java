package crackinginterview.sortingandsearchimg;

import java.util.Arrays;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class SortArrayOfAnagrams {
    public String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
