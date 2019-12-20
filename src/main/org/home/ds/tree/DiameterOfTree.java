package org.home.ds.tree;

public class DiameterOfTree {
    class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private int height(Node root){
        if(root == null){
            return 0;
        }else{
            return 1+ Math.max(height(root.left),height(root.right));
        }
    }

    public int diameter(Node root){
        if(root == null){
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        return Math.max((lHeight+rHeight+1),Math.max(lDiameter,rDiameter));
    }
}
