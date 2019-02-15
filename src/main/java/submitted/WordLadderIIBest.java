package submitted;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/submissions/detail/208130687/
 * time: O(n*26^l) -> O(n*26^l/2), l = len(word)
 * space: O(n + k * l), k = number of paths
 */
public class WordLadderIIBest {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<List<String>>();

        if (beginWord == null || endWord == null || wordList == null) {
            return res;
        }

        // for better performance
        HashSet<String> wordSet = new HashSet<>(wordList);

        Queue<WordNode> wordQueue = new LinkedList<>();
        //current level visited nodes
        Set<String> curLevel = new HashSet<>();

        wordQueue.offer(new WordNode(beginWord, new ArrayList<>(), 1));
        curLevel.add(beginWord);

        boolean foundEnd = false;

        while (!wordQueue.isEmpty() && !foundEnd) {
            // remove all previous traversed level of nodes so that there is no duplicates on different levels
            // but the duplicate newWord are allowed on the same level
            wordSet.removeAll(curLevel);
            curLevel.clear();

            int size = wordQueue.size();

            // for clearing all current level visited nodes
            for (int w = 0; w < size; w++) {
                WordNode top = wordQueue.poll();

                char[] chs = top.word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        char curr = chs[i];

                        chs[i] = ch;

                        String newWord = String.valueOf(chs);
                        // So that the new word pointed by multiple previous level of nodes are still considered
                        if (wordSet.contains(newWord)) {
                            WordNode newNode = new WordNode(newWord, top.path, top.steps + 1);
                            if (newWord.equals(endWord)) {
                                //Since we are using BFS, the first time this block gets executed, we found the shortest steps.
                                res.add(newNode.path);
                                foundEnd = true;
                            }

                            wordQueue.offer(newNode);
                            curLevel.add(newWord);
                        }

                        chs[i] = curr;
                    }
                }

            }

        }

        return res;
    }

    class WordNode {
        String       word;
        List<String> path;
        int          steps;

        WordNode(String word, List<String> path, int steps) {
            this.word = word;
            this.path = new ArrayList<>(path);
            this.path.add(word);
            this.steps = steps;
        }
    }
}
