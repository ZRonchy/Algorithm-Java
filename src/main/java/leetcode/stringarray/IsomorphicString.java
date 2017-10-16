package leetcode.stringarray;
// Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic
// if the characters in s can be replaced to get t.
// For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "ftd";
        System.out.println(isIsomorphic(s1, t1));

        String s2 = "egg";
        String t2 = "add";
        System.out.println(isIsomorphic(s2, t2));
    }

    private static boolean isIsomorphic(String s, String t) {
        if(s==null||t==null)
            return false;

        if(s.length()!=t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if(map.get(c1)!= c2)// if not consistent with previous ones
                   return false;
            } else {
                if (map.containsValue(c2)) //if c2 is already being mapped
                   return false;
                map.put(c1, c2);
            }
        }

        return true;
    }
}
