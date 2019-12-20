package org.home.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraveller<T> {
    private int MAX_LEVEL;

    public TreeTraveller() {
        MAX_LEVEL = Integer.MIN_VALUE;
    }

    public List<T> inorderTraversalWithoutRecursion(BinaryTree btree) {
        Stack<Node> stack = new Stack();
        ArrayList<T> seq = new ArrayList<T>();
        stack.push(btree.getRoot());
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            seq.add((T) node.getElement());
            if (!node.isLeafNode()) {
                if (node.hasRightChild()) {
                    stack.push(node.getRightChild());
                }
                if (node.hasLeftChild()) {
                    stack.push(node.getLeftChild());
                }


            }

        }
        return seq;
    }

    public void leftViewBinaryTree(TreeNodeInt root) {
        leftViewRec(root, 0);
    }

    public void leftViewRec(TreeNodeInt node, int level) {
        if (node == null) {
            return;
        }
        if (level > MAX_LEVEL) {
            MAX_LEVEL = level;
            System.out.println(node.getKey());
        }
        leftViewRec(node.getLeft(), level + 1);
        leftViewRec(node.getLeft(), level + 1);

    }

}
