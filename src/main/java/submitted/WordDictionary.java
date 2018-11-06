package submitted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/submissions/detail/187920723/
 * Add: O(1)
 * Search: O(n*m),
 * m: length of word to search
 * n: number of words with length m
 * Could also use Trie. Check https://wdxtub.com/interview/14520604445699.html
 */
public class WordDictionary {
    Map<Integer, List<String>> map;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        int l = word.length();
        if (!map.containsKey(l)) map.put(l, new ArrayList<String>());
        map.get(l).add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int l = word.length();
        if (map.containsKey(l)) {
            List<String> words = map.get(l);
            for (String w : words) if (compare(w, word)) return true;
        }
        return false;
    }

    private boolean compare(String s1, String s2) {
        int p = 0;
        while (p < s1.length()) {
            if (s2.charAt(p) != '.' && s1.charAt(p) != s2.charAt(p)) {
                return false;
            }
            p++;
        }
        return true;
    }
}