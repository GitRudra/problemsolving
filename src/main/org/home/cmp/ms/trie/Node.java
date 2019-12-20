package org.home.cmp.ms.trie;

public class Node {

    private char value;
    private Node[] children;
    private boolean validWord;
    private int hitCount;
    private String prefix;

    public Node() {
        children = new Node[26];
        prefix = "";
        validWord = false;
        hitCount = 0;
    }

    public Node(char value) {
        this();
        this.value = value;
    }

    /**
     * @return the value
     */
    public char getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * @return the children
     */
    public Node[] getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Node[] children) {
        this.children = children;
    }


    public boolean isValidWord() {
        return validWord;
    }

    public void setValidWord(boolean validWord) {
        this.validWord = validWord;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
