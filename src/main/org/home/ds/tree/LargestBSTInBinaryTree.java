package org.home.ds.tree;

public class LargestBSTInBinaryTree {
    public int largestBst(TreeNode root) {
        if(root == null){
            return -1;
        }
        LargestBSTResult result = largestBstUtil(root);
        return result.size;
    }

    private LargestBSTResult largestBstUtil(TreeNode root) {
        if (root == null) {
            return new LargestBSTResult(true,
                    0,
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE);
        }
        if (isLeaf(root)) {
            return new LargestBSTResult(true, 1, root.val, root.val);
        }
        LargestBSTResult left = largestBstUtil(root.left);
        LargestBSTResult right = largestBstUtil(root.right);
        if (left.isBst && right.isBst
                && root.val > left.maxValue
                && root.val < right.minValue) {
            return new LargestBSTResult(true,
                    left.size + right.size + 1,
                    left.minValue,
                    right.maxValue);
        } else {
            return new LargestBSTResult(false,
                    Math.max(left.size, right.size),
                    root.val,
                    root.val);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }

}

class LargestBSTResult {
    public boolean isBst;
    public int size;
    public int minValue;
    public int maxValue;

    public LargestBSTResult(boolean isBst, int size, int minValue, int maxValue) {
        this.isBst = isBst;
        this.size = size;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}

