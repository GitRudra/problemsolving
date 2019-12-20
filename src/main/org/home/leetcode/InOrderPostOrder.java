package org.home.leetcode;

public class InOrderPostOrder {
    private int POSTORDER_INDEX;

    public TreeNode buildTreeFromInPostUtil(int[] inorder, int[] postOrder,
                                            int inStart, int inEnd) {
        if (inEnd < inStart) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[POSTORDER_INDEX]);

        if (inStart == inEnd) {
            return root;
        }
        int inOrderIndex = findInteger(inorder, postOrder[POSTORDER_INDEX], inStart, inEnd);
        POSTORDER_INDEX--;
        root.right = buildTreeFromInPostUtil(inorder, postOrder, inOrderIndex + 1, inEnd);
        POSTORDER_INDEX--;
        root.left = buildTreeFromInPostUtil(inorder, postOrder, inStart, inOrderIndex - 1);
        return root;
    }

    private int findInteger(int[] input, int c, int s, int e) {
        if (s > e) {
            return -1;
        }
        for (int i = s; i <= e; i++) {
            if (input[i] == c) {
                return i;
            }
        }

        return -1;
    }

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        POSTORDER_INDEX = postOrder.length - 1;
        return buildTreeFromInPostUtil(inOrder, postOrder, 0, inOrder.length - 1);
    }

}
