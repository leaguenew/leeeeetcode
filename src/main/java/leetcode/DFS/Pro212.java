package leetcode.DFS;

import java.util.*;

/**
 * @program: risk-leecode-example
 * @description:
 * @author: niuliguo
 * @create: 2020-03-03 10:56
 **/
public class Pro212 {


    private Set<String> resSet = new HashSet<>();
    private int row, col;
    public List<String> findWords(char[][] board, String[] words) {
        if (null == board || board.length == 0 || null == words || words.length == 0) {
            return new LinkedList<>(resSet);
        }
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        // Arrays.fill(visited, false);

        //构建trie树
        Trie trieRoot = new Trie();
        for(int i = 0; i < words.length; i++) {
            trieRoot.insert(words[i]);
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                dfs(board, i, j, visited, trieRoot.trieRoot);
            }
        }

        return new LinkedList<>(resSet);
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, Trie.TrieNode root) {
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j]) {
            return;
        }

        root = root.children[board[i][j] - 'a'];

        if (null == root) {
            return;
        }

        if (root.isWord) {
            resSet.add(root.val);
        }

        visited[i][j] = true;

        dfs(board, i + 1, j , visited, root);
        dfs(board, i - 1, j , visited, root);
        dfs(board, i, j + 1 , visited, root);
        dfs(board, i, j - 1 , visited, root);

        visited[i][j] = false;//回溯

        return;
    }

    public static void main(String[] args) {

    }
}


class Trie {

    class TrieNode {
        public boolean isWord = false;
        public String val;
        public Trie.TrieNode[] children = new Trie.TrieNode[26];

        public TrieNode() {

        }

        public TrieNode(String val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    public TrieNode trieRoot = new Trie.TrieNode("");

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode root = trieRoot;
        for (int i = 0; i < chars.length; i++) {
            if (root.children[chars[i] - 'a'] == null) {
                root.children[chars[i] - 'a'] = new TrieNode(root.val + String.valueOf(chars[i]));
            }
            root = root.children[chars[i] - 'a'];
        }

        root.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode root = trieRoot;
        for (int i = 0; i < chars.length; i++) {
            if (root.children[chars[i] - 'a'] == null) {
                return false;
            }
            root = root.children[chars[i] - 'a'];
        }

        return root.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode root = trieRoot;
        for (int i = 0; i < chars.length; i++) {
            if (root.children[chars[i] - 'a'] == null) {
                return false;
            }
            root = root.children[chars[i] - 'a'];
        }

        return true;
    }
}