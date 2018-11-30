package submitted;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/192482337/
 * time: O(n)
 * time: O(n)
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        // improve efficiency. set.contains() is much more efficient than list.contains()
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){ // to calculate level of BFS
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level+1;
                }
                visited.add(word);
                for (int j=0;j<word.length();j++) {
                    char[] words = word.toCharArray();
                    for (char ch = 'a'; ch<='z'; ch++) {
                        words[j] = ch;
                        String newWord = new String(words);
                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
