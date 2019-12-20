package org.home.ds.tree;

public class MaximumPathSumOfBinaryTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int maxPathSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        maxPathSum = Integer.MIN_VALUE;
        findMaxSumPath(root);
        return maxPathSum;
    }

    private static int findMaxSumPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lValue = findMaxSumPath(root.left);
        int rValue = findMaxSumPath(root.right);

        int maxSingle = Math.max(root.val, Math.max(lValue, rValue) + root.val);

        int maximum = Math.max(maxSingle, root.val + lValue + rValue);
        maxPathSum = Math.max(maximum, maxPathSum);

        return maxSingle;
    }

    class Result {
        int sumNumbers;
        int maxPathSum;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result res = new Result();
        sumNumbersUtil(root, res, "");
        return res.sumNumbers;

    }

    public static void sumNumbersUtil(TreeNode root, Result res, String number) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            res.sumNumbers = res.sumNumbers + Integer.parseInt(number);
            return;
        }

        sumNumbersUtil(root.left, res, number + root.val);
        sumNumbersUtil(root.right, res, number + root.val);
    }

    public static boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }


    /**
     * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
     * <p>
     * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
     * <p>
     * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [0,1,2,3,4,3,4]
     * Output: "dba"
     * <p>
     * Example 2:
     * <p>
     * Input: [25,1,3,1,3,0,2]
     * Output: "adz"
     * <p>
     * Example 3:
     * <p>
     * Input: [2,2,1,null,1,0,null,0]
     * Output: "abc"
     * <p>
     * <p>
     * <p>
     * Note:
     * <p>
     * The number of nodes in the given tree will be between 1 and 8500.
     * Each node in the tree will have a value between 0 and 25.
     *
     * @param root
     * @return
     */
    public String smallestFromLeaf(TreeNode root) {
        if(root == null){
            return "";
        }
        if(isLeaf(root)){
            return String.valueOf('a'+root.val);
        }
        return smallestFromLeafUtil(root);
    }

    private static String smallestFromLeafUtil(TreeNode root){
        if(root == null){
            return "";
        }
        if(isLeaf(root)){
            return String.valueOf('a'+root.val);
        }else{
            String l = smallestFromLeafUtil(root.left);
            String r = smallestFromLeafUtil(root.right);
            return compareString(l,r)+String.valueOf('a'+root.val);
        }
    }

    private static String compareString(String s1, String s2){
        int compValue = s1.compareTo(s2);
        if(compValue<=0){
            return s1;
        }else{
            return s2;
        }
    }
}
