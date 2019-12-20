package org.home.leetcode.wordSearch2;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void findWords() {
        char[][] board = {  {'o','a','a','n'},
                            {'e','t','a','e'},
                            {'i','h','k','r'},
                            {'i','f','l','v'}};


        String[] words = {"oath","pea","eat","rain"};
        WordSearch search = new WordSearch();
        search.findWords(board,words);
    }
}