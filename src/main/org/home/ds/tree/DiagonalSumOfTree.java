package org.home.ds.tree;

import java.util.HashMap;

/**
 * Algorithm:
 * The idea is to keep track of vertical distance from top diagonal passing through root.
 * We increment the vertical distance we go down to next diagonal.
 * 1. Add root with vertical distance as 0 to the queue.
 * 2. Process the sum of all right child and right of right child and so on.
 * 3. Add left child current node into the queue for later processing.
 * The vertical distance of left child is vertical distance of current node plus 1.
 * 4. Keep doing 2nd, 3rd and 4th step till the queue is empty.
 */
public class DiagonalSumOfTree {

    public void diagonalSumOfBinaryTree(TreeNodeInt root){
        if(root == null){
            return;
        }
        HashMap<Integer,Integer> mapping = new HashMap<>();
        diagonalSumUtil(root,mapping,0);
//        mapping.forEach((K,V,mw));
        mapping.forEach((k,v)-> System.out.println("Diagonal "+k.intValue()+" Sum "+ v.intValue()));
    }

    private void diagonalSumUtil(TreeNodeInt root, HashMap<Integer,Integer> mapping, int label){
        if(root == null){
            return;
        }
        if(mapping.containsKey(label)){
            int curValue = mapping.get(label);
            mapping.put(label,curValue+root.getKey());
        }else{
            mapping.put(label,root.getKey());
        }

        diagonalSumUtil(root.getLeft(),mapping,label+1);
        diagonalSumUtil(root.getRight(),mapping,label);
    }
}
