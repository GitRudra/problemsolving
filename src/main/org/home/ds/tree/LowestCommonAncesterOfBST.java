package org.home.ds.tree;

public class LowestCommonAncesterOfBST {
    public TreeNodeInt getLCABST(TreeNodeInt root, int key1, int key2){
        return getLCABSTIterativeUtil(root,key1,key2);
    }

    private TreeNodeInt getLCABstUtil(TreeNodeInt root, int key1, int key2){
        if(root == null){
            return null;
        }
        if(root.key>key1 && root.key > key2){
            return getLCABstUtil(root.left,key1,key2);
        }
        if(root.key<key1 && root.key < key2){
            return getLCABstUtil(root.right,key1,key2);
        }
        return root;
    }

    private TreeNodeInt getLCABSTIterativeUtil(TreeNodeInt root, int key1, int key2){
        while(root != null){
            if(root.key>key1 && root.key > key2){
                root = root.left;
            }else if(root.key<key1 && root.key < key2){
                root = root.right;
            }else{
                break;
            }
        }
        return root;
    }
}
