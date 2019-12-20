package org.home.cmp.ms.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrieStructure {

    Node root;

    TrieStructure() {
        root = new Node();
    }

    public Node getRoot() {
        return root;
    }

    public boolean addWord(String word) {
        Node temp = root;
        String prefix = root.getPrefix();
        if (word != null && word.length() > 0) {
            for (int i = 0; i < word.length(); i++) {
                if (temp.getChildren()[word.charAt(i) - 'a'] == null) {
                    Node n = new Node(word.charAt(i));
                    n.setPrefix(prefix);
                    prefix += String.valueOf(word.charAt(i));
                    temp.getChildren()[word.charAt(i) - 'a'] = n;
                }else{
                    prefix = temp.getChildren()[word.charAt(i) - 'a'].getPrefix();
                }
                temp = temp.getChildren()[word.charAt(i) - 'a'];
            }
        }
        temp.setValidWord(true);
        temp.setPrefix(prefix);
        return true;
    }

    public List<String> getWords(String prefix) {
        Node temp = root;
        Boolean prefixFound = true;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.getChildren()[prefix.charAt(i) - 'a'] != null) {
                System.out.println(" Prefix : " + temp.getPrefix() );
                temp = temp.getChildren()[prefix.charAt(i) - 'a'];

            } else {
                prefixFound = false;
                break;
            }
        }
        if (prefixFound) {

            return findChildSubStrings(temp, prefix);
        } else {
            return Collections.emptyList();
        }

    }

    private ArrayList<String> findChildSubStrings(Node temp, String word) {
        ArrayList<String> results = new ArrayList<>();
        if (temp != null && !temp.isValidWord()) {
            subStringUtil(temp, word, results);
        } else {
            results.add(word);
        }
        return results;
    }

    private void subStringUtil(Node temp, String sb, ArrayList<String> results) {
        if (temp.isValidWord()) {
            results.add(sb);
            temp.setHitCount(temp.getHitCount() + 1);
        }
        for (int i = 0; i < 26; i++) {
            if (temp.getChildren()[i] != null) {
                StringBuilder sbuilder = new StringBuilder(sb);
                sbuilder.append(temp.getChildren()[i].getValue());
                subStringUtil(temp.getChildren()[i], sbuilder.toString(), results);
            }
        }
    }


}
