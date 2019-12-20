package org.home.algo.dictonary;

public class TernarySearchTree {

    class Node{
        Character key;
        Node lowKid;
        Node highKid;
        Node equalKid;
        Node parent;
        boolean isEndOfString;

        public Node(Character ch) {
            this.key = ch;
            lowKid = null;
            highKid = null;
            equalKid = null;
            parent = null;
            isEndOfString= false;
        }

        public Character getKey() {
            return key;
        }

        public void setKey(Character key) {
            this.key = key;
        }

        public Node getLowKid() {
            return lowKid;
        }

        public void setLowKid(Node lowKid) {
            this.lowKid = lowKid;
        }

        public Node getHighKid() {
            return highKid;
        }

        public void setHighKid(Node highKid) {
            this.highKid = highKid;
        }

        public Node getEqualKid() {
            return equalKid;
        }

        public void setEqualKid(Node equalKid) {
            this.equalKid = equalKid;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    private Node root;

    private void insertUtil(String word){
        int i = 0;
        if(root == null){
            root = new Node(word.charAt(0));
            i=1;
        }else{
            i=0;
        }
        Node temp = root;
        boolean inserted = false;
        for(;i<word.length();i++,inserted = false){
            char ch  = word.charAt(i);
            while(!inserted){
                if(ch<temp.key){
                    if(temp.lowKid == null){
                        Node t = new Node(ch);
                        t.parent = temp;
                        temp.lowKid = t;
                        inserted = true;
                    }
                    temp = temp.lowKid;
                }else if(ch==temp.key){
                    /*if(temp.equalKid == null){
                        LevelOrderTreeNode t = new LevelOrderTreeNode(ch);
                        t.parent = temp;
                        temp.equalKid = t;
                        inserted = true;
                    }
                    temp = temp.equalKid;*/
                    inserted = true;
                }else {
                    if(temp.highKid == null){
                        Node t = new Node(ch);
                        t.parent = temp;
                        temp.highKid = t;
                        inserted = true;
                    }
                    temp = temp.highKid;
                }
            }
        }
        temp.isEndOfString = true;

    }

    public void insert(String word){
        if(word == null || word.length()==0){
            return;
        }
       insertUtil(word);
    }

    public boolean search(String word){
        if(word == null || word.length()==0){
            return false;
        }
        Node temp = root;
        return searchUtil(temp,word,0);
    }

    private boolean searchUtil(Node root, String word, int idx){
        if(root == null){
            return  false;
        }
        if(word.charAt(idx) < root.key){
            return searchUtil(root.lowKid,word,idx);
        }else if(word.charAt(idx) > root.key){
            return searchUtil(root.highKid,word,idx);
        }else{
            if(idx==word.length()){
                return root.isEndOfString;
            }
            return searchUtil(root.equalKid,word,idx+1);
        }

    }
}
