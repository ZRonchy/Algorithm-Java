package submitted;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllStringsWithWildcard {
    public static void main(String[] args) {
        System.out.println(generateAllPatterns("100?01?1"));
    }

    public static List<String> generateAllPatterns(String s) {
        List<String> res = new ArrayList<>();
        generateAllPatterns(res, s, 0);
        return res;
    }

    public static void generateAllPatterns(List<String> res, String s, int index) {
        while (index < s.length() && s.charAt(index) != '?') {
            System.out.println(index);
            index++;
        }
        if (index == s.length()) {
            res.add(s);
            return;
        }
        StringBuilder s1 = new StringBuilder(s);
        s1.setCharAt(index, '0');
        generateAllPatterns(res, s1.toString(), index);
        s1.setCharAt(index, '1');
        generateAllPatterns(res, s1.toString(), index);
    }

}
