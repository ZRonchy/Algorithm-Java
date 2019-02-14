package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/207959378/
 * Time Complexity: O(N^2 *log N), where N is the number of words, and assuming
 * their length is O(1)O(1). Each call to solve is O(N^2) and the number of calls is bounded by O(log N)
 * Space Complexity: O(N^2)
 */
public class GuessTheWord {
    int[][] H;

    public void findSecretWord(String[] wordlist, Master master) {
        int N = wordlist.length;
        // Store H[i][j] as the number of matches of wordlist[i] and wordlist[j]
        H = new int[N][N];
        for (int i = 0; i < N; ++i)
            for (int j = i; j < N; ++j) {
                int match = 0;
                for (int k = 0; k < 6; ++k)
                    if (wordlist[i].charAt(k) == wordlist[j].charAt(k))
                        match++;
                H[i][j] = H[j][i] = match;
            }

        List<Integer> possible = new ArrayList();
        List<Integer> path = new ArrayList();
        for (int i = 0; i < N; ++i) possible.add(i);

        while (!possible.isEmpty()) {
            // find the index of string to minimize the maxGroup size
            int guess = solve(possible, path);
            int matches = master.guess(wordlist[guess]);
            if (matches == wordlist[0].length()) return;
            List<Integer> possible2 = new ArrayList();
            for (Integer j : possible) {
                // j is possible only when H[guess][j] == matches
                if (H[guess][j] == matches) possible2.add(j);
            }
            possible = possible2;
            path.add(guess); // already guessed the same string
        }

    }

    // return the guess index that will lead to minimize maxGroup.
    // We can guess that having less words in the word list is generally better.
    // so we try to minimize the next list of words to guess, which is next List<Integer> possible
    public int solve(List<Integer> possible, List<Integer> path) {
        if (possible.size() <= 2) return possible.get(0);
        List<Integer> ansgrp = possible;
        int ansguess = -1;

        for (int guess = 0; guess < H.length; ++guess) {
            if (!path.contains(guess)) {
                ArrayList<Integer>[] groups = new ArrayList[7];
                for (int i = 0; i < 7; ++i) groups[i] = new ArrayList<Integer>();
                for (Integer j : possible)
                    if (j != guess) {
                        groups[H[guess][j]].add(j);
                    }

                ArrayList<Integer> maxgroup = groups[0];
                for (int i = 0; i < 7; ++i)
                    if (groups[i].size() > maxgroup.size())
                        maxgroup = groups[i];

                if (maxgroup.size() < ansgrp.size()) {
                    ansgrp = maxgroup;
                    ansguess = guess;
                }
            }
        }

        return ansguess;
    }
}

class Master {
    int guess(String s) {
        return 0;
    }
}