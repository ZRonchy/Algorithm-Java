package leetcode.stringarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Given two words (start and end), and a dictionary, find the length of shortest transformation sequence
// from start to end, such that only one letter can be changed at a time and each intermediate word must
// exist in the dictionary. For example, given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// the program should return its length 5.

//Breadth-first search
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> dict = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        int ladderLength = ladderLength(beginWord, endWord, dict);
        System.out.print(ladderLength);
    }

    // BFS
    private static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endWord)){
                    return level + 1;
                }

                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)){
                            System.out.println(check);
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
