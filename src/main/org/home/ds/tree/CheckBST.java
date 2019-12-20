package org.home.ds.tree;

public class CheckBST {

    boolean checkBST(TreeNodeInt root) {
        if(root == null){
            return true;
        }
        return isLeftSubTreeInBst(root.left,root) &&
                isRightSubTreeInBst(root.right, root)&&
                checkBST(root.left) &&
                checkBST(root.right);
    }
    private boolean isLeftSubTreeInBst(TreeNodeInt lTree, TreeNodeInt parent){
        if(lTree == null){
            return true;
        }
        return lTree.data < parent.data;
    }
    private boolean isRightSubTreeInBst(TreeNodeInt rTree, TreeNodeInt parent){
        if(rTree == null){
            return true;
        }
        return rTree.data >= parent.data;
    }



}
