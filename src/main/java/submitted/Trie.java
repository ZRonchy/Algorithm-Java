package submitted;

/**
 * https://leetcode.com/submissions/detail/205321171/
 * Time Complexity: Insert/search O(l), l is the length of the word
 * Space Complexity: O(prefixes), O(n * l * l) n words with length l
 */
public class Trie {
    class TrieNode {
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
        public boolean isWord;
        public TrieNode[] children;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }

    private TrieNode find(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (p.children[index] == null) {
                return null;
            }
            p = p.children[index];
        }
        return p;
    }
}
