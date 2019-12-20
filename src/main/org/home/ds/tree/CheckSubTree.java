package org.home.ds.tree;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Given two binary trees, check if the first tree is subtree of the second one.
 * A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.
 * The subtree corresponding to the root node is the entire tree;
 * the subtree corresponding to any other node is called a proper subtree.
 */
public class CheckSubTree {

    /**
     * The method check whether <code>subTree</code> is a sub tree of
     * <code>source</code>. Time complexity O(mn) where m & n are the number of nodes
     * in source and subtree
     *
     * @param source The Source Tree
     * @param subTree The Sub Tree
     * @return
     */
    public boolean checkSubTreeOne(TreeNodeChar source, TreeNodeChar subTree){
        if(source == null && subTree == null){
            return true;
        }
        if(source == null || subTree == null){
            return false;
        }

        if(areIdentical(source,subTree)){
            return true;
        }

        return checkSubTreeOne(source.getLeft(),subTree) ||
                checkSubTreeOne(source.getRight(),subTree);

    }

    /**
     * Utility method to check equality of both the tree
     * @param source
     * @param subTree
     * @return
     */
    private boolean areIdentical(TreeNodeChar source, TreeNodeChar subTree){
        if(source == null && subTree == null){
            return true;
        }
        if(source == null || subTree == null){
            return false;
        }
        return (source.getKey() == subTree.getKey()) &&
                areIdentical(source.getLeft(),subTree.getLeft()) &&
                areIdentical(source.getRight(),subTree.getRight());
    }

    private void createInOrderString(TreeNodeChar root, ArrayList<Character> store){
        if(root == null){
            return;
        }
        createInOrderString(root.getLeft(),store);
        store.add(root.getKey());
        createInOrderString(root.getRight(),store);
    }

    private void createPreOrderString(TreeNodeChar root, ArrayList<Character> store){
        if(root == null){
            return;
        }
        store.add(root.getKey());
        createPreOrderString(root.getLeft(),store);
        createPreOrderString(root.getRight(),store);
    }

    private boolean isSubArray(ArrayList<Character> sup, ArrayList<Character> sub){
        if(sub.size() > sup.size()){
            return false;
        }
        String supStr = sup.stream()
                .map(e -> e.toString())
                .collect(Collectors.joining());
        String subStr = sub.stream()
                .map(e -> e.toString())
                .collect(Collectors.joining());

        return supStr.indexOf(subStr) >= 0;

    }

    /**
     * The method check whether <code>subTree</code> is a sub tree of
     * <code>source</code>.
     * Approach : A tree can be uniquely identified by the
     * inorder and pre/postorder traversal.
     * One three t1 can be subtree of t2 if
     * <ul>
     * <li> PreOrderTraversal(t1) is a substring of PreOrderTraversal(t2</li>
     * <li> InOrderTraversal(t1) is a substring of InOrderTraversal(t2</li>
     * </ul>
     *
     * @param source  The Source Tree
     * @param subTree The Sub Tree
     * @return true if subtree
     */
    public boolean checkSubTreeTwo(TreeNodeChar source, TreeNodeChar subTree) {
        ArrayList<Character> inOrderSuperTree = new ArrayList<>();
        ArrayList<Character> inOrderSubTree = new ArrayList<>();
        ArrayList<Character> preOrderSuperTree = new ArrayList<>();
        ArrayList<Character> preOrderSubTree = new ArrayList<>();
        createInOrderString(source, inOrderSuperTree);
        createInOrderString(subTree, inOrderSubTree);

        createPreOrderString(source, preOrderSuperTree);
        createPreOrderString(subTree, preOrderSubTree);

        return isSubArray(inOrderSuperTree, inOrderSubTree)
                && isSubArray(preOrderSuperTree, preOrderSubTree);
    }


}
