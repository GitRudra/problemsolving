package org.home.leetcode.wordSearch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    char ch;
    TrieNode[] children;
    boolean isWord;

    public TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[26];
        isWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void buildTrie(List<String> words) {
        for (String s : words) {
            insertTrie(s);
        }
    }

    private void insertTrie(String word) {
        TrieNode temp = root;
        int start = 0;
        int end = word.length();
        while (start < end) {
            if (temp.children[word.charAt(start) - 'a'] == null) {
                temp.children[word.charAt(start) - 'a'] =
                        new TrieNode(word.charAt(start));
            }
            temp = temp.children[word.charAt(start) - 'a'];
            start++;
        }
        temp.isWord = true;
    }

    public int checkPrefixOrWord(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.children[prefix.charAt(i) - 'a'] == null) {
                return -1;
            } else {
                temp = temp.children[prefix.charAt(i) - 'a'];
            }
        }
        return temp.isWord ? 1 : 0;
    }

}


public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        trie.buildTrie(Arrays.asList(words));
        int row = board.length;
        int col = board[0].length;
        ArrayList<String> foundWords = new ArrayList<>();
        for(int i= 0;i< row;i++){
            for(int j = 0;j<col;j++){
                dfs(board,"",i,j,row,col,trie,foundWords);
            }
        }

        //foundWords.forEach(e-> System.out.println(e));

        return foundWords;
    }

    private boolean validateBoundary(int x, int y, int row, int col) {
        if (x >= 0 && x < row && y >= 0 && y < col) {
            return true;
        } else {
            return false;
        }
    }


    private void dfs(char[][] arr, String prefix, int x, int y, int row, int col, Trie trie,
                     ArrayList<String> words) {
        if (!validateBoundary(x, y, row, col)) {
            return;
        }
        prefix += Character.toString(arr[x][y]);
        int val = trie.checkPrefixOrWord(prefix);
        if (val == 1) {
            words.add(prefix);
        } else if (val == -1) {
        } else {
            dfs(arr, prefix, x + 1, y, row, col,  trie, words);
            dfs(arr, prefix, x - 1, y, row, col, trie, words);
            dfs(arr, prefix, x, y + 1, row, col, trie, words);
            dfs(arr, prefix, x, y - 1, row, col, trie, words);
        }

    }

}

