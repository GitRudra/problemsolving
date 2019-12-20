package org.home.ds.tree;

import sun.reflect.generics.tree.Tree;

public class AVLTree {

    public TreeNodeInt insert(TreeNodeInt root, int key){
        if(root == null){
            return new TreeNodeInt(key);
        }
        if(key<=root.getKey()){
            root.setLeft(insert(root.getLeft(),key));
        }else{
            root.setRight(insert(root.getRight(),key));
        }
        root.setHeight(1+ Math.max(height(root.getLeft()), height(root.getRight())));
        return root;
    }

    private int height(TreeNodeInt node){
        return 0;
    }
}
