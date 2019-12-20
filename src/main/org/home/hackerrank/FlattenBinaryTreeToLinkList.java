package org.home.hackerrank;

import org.home.ds.tree.TreeNode;

public class FlattenBinaryTreeToLinkList {

    public static TreeNode flattenBinaryTree(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left != null){
            flattenBinaryTree(root.left);
        }else{
            root.left = flattenBinaryTree(root.right);
        }

        return root;
    }

    public void flatten(TreeNode root) {

        if(root == null){
            return;
        }

        if(root.right!=null){
            flatten(root.right);
        }
        if(root.left!=null){
            flatten(root.left);
        }
        if(root.left!= null && root.right!= null){
            root.left.right = root.right;
            root.right = root.left;
        }
    }
}
