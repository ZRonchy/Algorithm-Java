package leetcode.stringarray;

import org.junit.Assert;

// Implement wildcard pattern matching with support for '?' and '*'.
// To understand this solution, you can use s="aab" and p="*ab"
public class WildcardMatching {

    public static void main(String[] args) {
        Assert.assertTrue(isMatch("acccabd", "*abc"));
    }

    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            System.out.println(s.charAt(i)+","+p.charAt(j)+", "+i+", "+j);
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex+1;
                iIndex++;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        System.out.print("!!");

        return j == p.length();
    }
}
