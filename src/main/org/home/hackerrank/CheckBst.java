package org.home.hackerrank;

public class CheckBst {

    class Node {
        int data;
        Node left;
        Node right;
    }
    boolean checkBST(Node root) {
        if(root == null){
            return false;
        }
        if(root.left!= null && root.right != null
                && root.data >= root.left.data && root.data < root.right.data ){
            return checkBST(root.left) && checkBST(root.right);
        }

        if(root.left == null && root.right != null && root.data < root.right.data){
            return checkBST(root.right);
        }

        if(root.left != null && root.right == null && root.data >= root.right.data){
            return checkBST(root.left);
        }

        return false;
    }
}
