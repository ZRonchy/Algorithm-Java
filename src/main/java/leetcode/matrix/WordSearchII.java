package leetcode.matrix;

import leetcode.TreeTrie.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * For example, given words = ["oath","pea","eat","rain"] and board =

     [
     ['o','a','a','n'],
     ['e','t','a','e'],
     ['i','h','k','r'],
     ['i','f','l','v']
     ]
     Return ["eat","oath"].
 * Similar to Word Search, this problem can be solved by DFS. However, this solution exceeds time limit.
 * Solution: If the current candidate does not exist in all words' prefix (Trie),
 * we can stop backtracking immediately. This can be done by using a trie structure.
 * */
public class WordSearchII {

    public static void main(String[] args) {
        char[][] grid = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        System.out.println(findWords(grid, new String[]{"oath", "pea","eat","rain"}));
    }


    public static List<String> findWords(char[][] grid, String[] words) {
        Set<String> result = new HashSet<>();

        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dfs(grid, visited, "", i, j, trie, result);
            }
        }

        return new ArrayList<String>(result);
    }

    private static void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie, Set<String> result){
        int m=board.length;
        int n=board[0].length;

        if(i<0 || j<0||i>=m||j>=n){
            return;
        }

        if(visited[i][j])
            return;

        str = str + board[i][j];

        if(!trie.startsWith(str))
            return;

        if(trie.search(str)){
            result.add(str);
        }

        visited[i][j]=true;
        dfs(board, visited, str, i-1, j, trie, result);
        dfs(board, visited, str, i+1, j, trie, result);
        dfs(board, visited, str, i, j-1, trie, result);
        dfs(board, visited, str, i, j+1, trie, result);
        visited[i][j]=false;
    }
}
