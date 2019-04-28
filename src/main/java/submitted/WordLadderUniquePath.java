package submitted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * time: O(n*26^l) -> O(n*26^l/2), l = len(word)
 * space: O(n + k * l), k = number of paths
 */
public class WordLadderUniquePath {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        HashSet<String> visited = new HashSet<>(wordList);

        LinkedList<Node> queue = new LinkedList<>();
        Node node = new Node(beginWord, 0, null);
        queue.offer(node);

        int minLen = Integer.MAX_VALUE;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                Node top = queue.poll();

                //top if have shorter result already
                if (result.size() > 0 && top.depth > minLen) {
                    return result;
                }

                for (int i = 0; i < top.word.length(); i++) {
                    char c = top.word.charAt(i);
                    char[] arr = top.word.toCharArray();
                    for (char j = 'z'; j >= 'a'; j--) {
                        if (j == c) {
                            continue;
                        }
                        arr[i] = j;
                        String t = new String(arr);

                        if (t.equals(endWord)) {
                            //add to result
                            List<String> aResult = new ArrayList<>();
                            aResult.add(endWord);
                            Node p = top;
                            while (p != null) {
                                aResult.add(p.word);
                                p = p.prev;
                            }

                            Collections.reverse(aResult);
                            result.add(aResult);

                            //stop if get shorter result
                            if (top.depth <= minLen) {
                                minLen = top.depth;
                            } else {
                                return result;
                            }
                        }

                        if (!visited.contains(t)) {
                            Node n = new Node(t, level, top);
                            queue.offer(n);
                            visited.add(t);
                        }
                    }
                }
            }
            level++;
        }

        return result;
    }

    class Node {
        public String word;
        public int depth;
        public Node prev;

        public Node(String word, int depth, Node prev) {
            this.word = word;
            this.depth = depth;
            this.prev = prev;
        }
    }
}
