package org.home.ds.tree;

import java.util.HashSet;
import java.util.Set;

public class SummationOnTree {

    private Integer BOTTOM_VIEW_SUM = 0;

    /**
     * The API will generate the sum of nodes from bottom view.
     * Logic:
     * The approach is bottom up. We will start summing the value from
     * bottom.
     * 1. For root node vertical distance(d) will be zero.
     * 2. For left child it will be d-1 and for right child it will be d+1.
     * 3. After reaching the leaf node we need to check whether the vertical distance
     * already considered for sum (using a set) as from bottom view one vertical distance
     * can not be considered twice.
     * 4. If the vertical distance is viewed then skip that node.
     * @param root
     * @return
     */
    public Integer sumOfNodesInBottomViewOfTree(TreeNodeInt root) {
        if (root == null) {
            return 0;
        }
        BOTTOM_VIEW_SUM = 0;
        Set<Integer> visitedVds = new HashSet<>();
        sumOfBottomViewUtil(root, visitedVds, 0);
        return BOTTOM_VIEW_SUM;

    }

    private void sumOfBottomViewUtil(TreeNodeInt root,
                                     Set<Integer> visitedVds,
                                     Integer currVd) {
        if (root == null) {
            return;
        }
        sumOfBottomViewUtil(root.getLeft(), visitedVds, currVd - 1);
        sumOfBottomViewUtil(root.getRight(), visitedVds, currVd + 1);
        if (!visitedVds.contains(currVd)) {
            BOTTOM_VIEW_SUM += root.getKey();
            visitedVds.add(currVd);
        }
    }

    private boolean isLeaf(TreeNodeInt root) {
        return (root != null) && (root.getLeft() == null) && (root.getRight() == null);
    }


    public TreeNodeInt createTree(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        } else {
            return createTreeUtil(input, 0);
        }
    }

    private TreeNodeInt createTreeUtil(int[] input, int index) {
        if (index >= input.length) {
            return null;
        }
        TreeNodeInt node = new TreeNodeInt(input[index]);
        node.setLeft(createTreeUtil(input, 2 * index + 1));
        node.setRight(createTreeUtil(input, 2 * (index + 1)));
        return node;
    }

    public void displayTree(TreeNodeInt root) {
        if (root == null) {
            return;
        }
        displayTree(root.getLeft());
        System.out.print(root.getKey() + " ");
        displayTree(root.getRight());
    }
}
