package org.home.ds.tree;

public class SmallestFromLeaf {
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

    private String smallestFromLeafUtil(TreeNode root){
        if(root == null){
            return "";
        }
        if(isLeaf(root)){
            return getString(root.val);
        }else{
            String l = smallestFromLeafUtil(root.left);
            String r = smallestFromLeafUtil(root.right);
            return getSmallerString(l,r)+getString(root.val);
        }
    }

    private String getString(int x){
        //(char)('a'+root.val)
        return String.valueOf((char)('a'+x));
    }

    public String getSmallerString(String s1, String s2){
        if(s1 == "" && s2 != ""){
            return s2;
        }
        if(s2 == "" && s1 != ""){
            return s1;
        }
        int compValue = s1.compareTo(s2);
        if(compValue<=0){
            if(isPrefix(s2,s1)){
                return s1;
            }else{
                return s2;
            }
            //return s1;
        }else{
            if(isPrefix(s1,s2)){
                return s1;
            }else{
                return s2;
            }
            //return s2;
        }
    }

    public boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    public boolean isPrefix(String str, String subStr){
        return (subStr.length() < str.length()) && (str.indexOf(subStr) == 0) ;
    }
}
