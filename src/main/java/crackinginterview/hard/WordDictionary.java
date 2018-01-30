package crackinginterview.hard;

import java.util.*;

/**
 * Given two words of equal length that are in a dictionary, write a method to transform one word into another
 * word by changing only one letter at a time. The new word you get in each step must be in the dictionary.
 */
public class WordDictionary {
    LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary) {
        startWord = startWord.toUpperCase();
        stopWord = stopWord.toUpperCase();
        Queue<String> actionQueue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();
        Map<String, String> backtrackMap = new TreeMap<>();

        actionQueue.add(startWord);
        visitedSet.add(startWord);

        while (!actionQueue.isEmpty()) {
            String w = actionQueue.poll();
            //For each possible word v from w with one edit operation
            for (String v : getOneEditWord(w)) {
                if (v.equals(stopWord)) {
                    //Found our word! Now back track
                    LinkedList<String> list = new LinkedList<>();
                    //Append v to list
                    list.add(v);
                    while (w != null) {
                        list.add(0, w);
                        w = backtrackMap.get(w);
                    }
                    return list;
                }

                // If v is a dictionary word
                if (dictionary.contains(v)) {
                    if (!visitedSet.contains(v)) {
                        actionQueue.add(v);
                        visitedSet.add(v);
                        backtrackMap.put(v, w);
                    }
                }
            }
        }
        return null;
    }

    private Set<String> getOneEditWord(String word) {
        Set<String> words = new TreeSet<>();
        for (int i = 0; i < word.length(); i++) {
            char[] wordArray = word.toCharArray();
            //change that letter to something else
            for (char c = 'A'; c<= 'Z';c++) {
                if (c != word.charAt(i)) {
                    wordArray[i] = c;
                    words.add(new String(wordArray));
                }
            }
        }
        return words;
    }
}
