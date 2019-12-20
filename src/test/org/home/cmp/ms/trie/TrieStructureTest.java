package org.home.cmp.ms.trie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrieStructureTest {
    public TrieStructure trie;

    @Test
    public void fetChFromTrieOne() {
        String[] expected = {"add","addiction","addition"};
        List<String> suggestions = trie.getWords("a");
        assertArrayEquals(expected,suggestions.toArray(new String[suggestions.size()]));
    }

    @Test
    public void fetChFromTrieTwo() {
        String[] expected = {"bat","batman","batting"};
        List<String> suggestions = trie.getWords("b");
        assertArrayEquals(expected,suggestions.toArray(new String[suggestions.size()]));
    }
    @Test
    public void fetChFromTrieThree() {
        String[] expected = {"gun"};
        List<String> suggestions = trie.getWords("g");
        assertArrayEquals(expected,suggestions.toArray(new String[suggestions.size()]));
    }

    @Test
    public void fetChFromTrieFour() {
        String[] expected = {"add","addiction","addition"};
        List<String> suggestions = trie.getWords("add");
        assertArrayEquals(expected,suggestions.toArray(new String[suggestions.size()]));
    }


    @Before
    public void setUp() throws Exception {
        trie = new TrieStructure();
        buildTrie();
    }

    private void buildTrie(){
        trie.addWord("add");
        trie.addWord("addition");
        trie.addWord("addiction");
        trie.addWord("bat");
        trie.addWord("batting");
        trie.addWord("batman");
        trie.addWord("gun");
    }
}