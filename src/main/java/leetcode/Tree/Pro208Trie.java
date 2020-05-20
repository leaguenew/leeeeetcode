package leetcode.Tree;

/**
 * @program: risk-leecode-example
 * @description: Pro208: 前缀树
 * @author: niuliguo
 * @create: 2020-03-02 21:49
 **/
public class Pro208Trie {

    class TrieNode {
        private boolean isWord = false;
        private char val;
        private TrieNode[] children = new TrieNode[26];

        public TrieNode() {

        }

        public TrieNode(char val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public Pro208Trie() {

    }

    public TrieNode trieRoot = new TrieNode();
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode root = trieRoot;
        for(int i = 0; i < chars.length; i++) {
            if (root.children[chars[i] - 'a'] == null) {
                root.children[chars[i] - 'a'] = new TrieNode(chars[i]);
            }
            root = root.children[chars[i] - 'a'];
        }

        root.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode root = trieRoot;
        for(int i = 0; i < chars.length; i++) {
            if (root.children[chars[i] - 'a'] == null) {
                return false;
            }
            root = root.children[chars[i] - 'a'];
        }

        return root.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode root = trieRoot;
        for(int i = 0; i < chars.length; i++) {
            if (root.children[chars[i] - 'a'] == null) {
                return false;
            }
            root = root.children[chars[i] - 'a'];
        }

        return true;
    }

    public static void main(String[] args) {
        Pro208Trie trie = new Pro208Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println((trie.startsWith("app"))); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
