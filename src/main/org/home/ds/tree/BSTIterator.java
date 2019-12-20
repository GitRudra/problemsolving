package org.home.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BSTIterator {

    List<TreeNode> elements;
    TreeNode root;
    ListIterator<TreeNode> it;

    public BSTIterator(TreeNode root) {
        this.root = root;
        elements = new ArrayList<>();
        inOrderTraversal(root);
        it = elements.listIterator();
    }

    private void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left);
        elements.add(node);
        inOrderTraversal(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        return it.next().val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return it.hasNext();
    }
}
