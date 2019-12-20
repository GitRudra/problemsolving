package org.home.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * We break the problem in 3 parts:
 * 1. Print the left boundary in top-down manner.
 * 2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
 * …..2.1 Print all leaf nodes of left sub-tree from left to right.
 * …..2.2 Print all leaf nodes of right subtree from left to right.
 * 3. Print the right boundary in bottom-up manner.
 *
 * We need to take care of one thing that nodes are not printed again. e.g. The left most node is also the leaf node of the tree.
 */
public class BoundaryOfABinaryTree {

    /**
     * Method to find the boundary of a tree.
     * @param root
     * @return boundary list.
     */
    public List<Integer> findBoundary(TreeNodeInt root){
        if(root == null){
            return Collections.emptyList();
        }
        //List to store the boundary.
        List<Integer> boundary = new ArrayList<>();
        //Adding the root node to the list
        boundary.add(root.getKey());
        //Start finding left boundary from root.left
        findLeftBoundary(root.getLeft(),boundary);
        //Finding leaf nodes
        findLeafNodes(root,boundary);
        //Finding right boundary
        findRightBoundary(root.getRight(),boundary);
        System.out.println(boundary);
        return boundary;
    }

    private void findLeftBoundary(TreeNodeInt root, List<Integer> boundary){
        if(root == null){
            return;
        }
        if(isLeafNode(root)){
            return;
        }else{
            if(root.getLeft() != null){
                boundary.add(root.getKey());
                findLeftBoundary(root.getLeft(),boundary);
            }
        }
    }

    private void findLeafNodes(TreeNodeInt root, List<Integer> boundary){
        if(root == null){
            return;
        }
        if(isLeafNode(root)){
            boundary.add(root.getKey());
            return;
        }
        findLeafNodes(root.getLeft(),boundary);
        findLeafNodes(root.getRight(),boundary);
    }

    private void findRightBoundary(TreeNodeInt root, List<Integer> boundary){
        if(root == null){
            return;
        }
        if(!isLeafNode(root)){
            if(root.getRight() != null){
                findRightBoundary(root.getRight(),boundary);
            }else if(root.getLeft() != null){
                findRightBoundary(root.getRight(),boundary);
            }
            boundary.add(root.getKey());
        }else{
            return;
        }
    }

    private boolean isLeafNode(TreeNodeInt root){
        return root != null && root.getLeft() == null && root.getRight()==null;
    }
}
