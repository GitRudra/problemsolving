package org.home.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    private int PREORDER_INDEX = 0;
    private int POSTORDER_INDEX;

    /**
     * Let us consider the below traversals:
     * <p>
     * Inorder sequence: D B E A F C
     * Preorder sequence: A B D E C F
     */
    public TreeNodeChar buildTreeFromInorderPreOrderTraversal(char[] inorder, char[] preorder) {
        if (inorder == null || preorder == null || inorder.length != preorder.length) {
            return null;
        }
        return buildTreeFromInPreUtil(inorder, preorder, 0, inorder.length - 1);
    }

    /**
     * Algorithm: buildTree()
     * <ol>
     * <li>Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.</li>
     * <li>Create a new tree node tNode with the data as picked element.</li>
     * <li>Find the picked element’s index in Inorder. Let the index be inIndex.</li>
     * <li>Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.</li>
     * <li>Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.</li>
     * <li>return tNode.</li>
     * </ol>
     *
     * @param inorder  char[] inorder sequence
     * @param preorder char[] preorder sequence
     * @param start    start position in inorder sequence
     * @param end      end position in inorder sequence
     * @return node {@link TreeNodeChar}
     */
    private TreeNodeChar buildTreeFromInPreUtil(char[] inorder, char[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNodeChar node = new TreeNodeChar(preorder[PREORDER_INDEX]);
        PREORDER_INDEX++;
        if (start == end) {
            return node;
        }
        int pos = findCharacter(inorder, node.getKey(), start, end);
        node.setLeft(buildTreeFromInPreUtil(inorder, preorder, start, pos - 1));
        node.setRight(buildTreeFromInPreUtil(inorder, preorder, pos + 1, end));
        return node;
    }

    /**
     * Helper method to search an element <code>c</code> in inorder sequence which starts from <code>s</code> and
     * ends in <code>e</code>
     *
     * @param input
     * @param c     char search key
     * @param s     int start index
     * @param e     int end index
     * @return - int position
     */
    private int findCharacter(char[] input, char c, int s, int e) {
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

    /**
     * Helper method to search an element <code>c</code> in inorder sequence which starts from <code>s</code> and
     * ends in <code>e</code>
     *
     * @param input
     * @param c     char search key
     * @param s     int start index
     * @param e     int end index
     * @return - int position
     */
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

    public void printInorder(TreeNodeChar root) {
        if (root == null) {
            return;
        } else {
            printInorder(root.getLeft());
            System.out.print(root.getKey() + " ");
            printInorder(root.getRight());
        }
    }

    public TreeNodeInt constructBinaryTreeFromLinkList(ListNode head){
        Queue<TreeNodeInt> queue = new LinkedList<>();
        ListNode tHead = head;
        TreeNodeInt root = new TreeNodeInt(tHead.key);
        tHead = tHead.next;
        TreeNodeInt temp = root;
        queue.add(temp);
        while(tHead != null){
            TreeNodeInt t = queue.remove();
            t.setLeft(new TreeNodeInt(tHead.key));
            queue.add(t.getLeft());
            tHead = tHead.next;
            if(tHead!=null){
                t.setRight(new TreeNodeInt(tHead.key));
                queue.add(t.getRight());
                tHead = tHead.next;
            }
        }

        return root;
    }

    public ListNode createLinkList(int[] input){
        ListNode head = new ListNode(input[0]);
        ListNode tHead = head;
        for(int i=1;i<input.length;i++){
            tHead.next = new ListNode(input[i]);
            tHead = tHead.next;
        }
        return head;
    }

    public void printTree(TreeNodeInt root){
        if(root == null){
            return;
        }
        printTree(root.getLeft());
        System.out.print(root.key+" ");
        printTree(root.getRight());
    }

    /**
     * It is not possible to construct a general Binary Tree from preorder and postorder traversals.
     * But if know that the Binary Tree is Full, we can construct the tree without ambiguity.
     * Let us understand this with the help of following example.
     * Let us consider the two given arrays as
     * pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and
     * post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
     * In pre[], the leftmost element is root of tree.
     * Since the tree is full and array size is more than 1.
     * The value next to 1 in pre[], must be left child of root.
     * So we know 1 is root and 2 is left child.
     * How to find the all nodes in left subtree?
     * We know 2 is root of all nodes in left subtree.
     * All nodes before 2 in post[] must be in left subtree.
     * Now we know 1 is root, elements {8, 9, 4, 5, 2} are in left subtree,
     * and the elements {6, 7, 3} are in right subtree.
     * @param preOrder
     * @param postOrder
     * @return
     * @throws Exception
     */
    public TreeNodeInt buildTreeFromPreAndPostOrderTraversal(int[]preOrder, int[] postOrder) throws Exception {
        if(preOrder == null || postOrder ==null){
            throw new Exception("Invalid Input");
        }
        if(preOrder.length != postOrder.length){
            throw new Exception("Invalid Input");
        }
        PREORDER_INDEX = 0;
        return buildTreeFromPreAndPostUtil(preOrder,postOrder,0,postOrder.length-1);

    }

    /**
     * Recursive function to build the tree.
     * @param preOrder
     * @param postOrder
     * @param postStartIndex
     * @param postEndIndex
     * @return
     */
    private TreeNodeInt buildTreeFromPreAndPostUtil(int[] preOrder, int[] postOrder,int postStartIndex,int postEndIndex){
        TreeNodeInt root = new TreeNodeInt(preOrder[PREORDER_INDEX]);
        //Boundary case:
        //
        if((postStartIndex >= postEndIndex) ||
                (PREORDER_INDEX >= preOrder.length)){
            return root;
        }
        PREORDER_INDEX++;
        //Find the position of preorder value in the post order sequence.
        int pos = findInteger(postOrder,preOrder[PREORDER_INDEX],postStartIndex,postEndIndex);
        //Creating the left subtree
        root.setLeft(buildTreeFromPreAndPostUtil(preOrder,postOrder,postStartIndex,pos-1));
        //Index need to be incremented for right sub tree
        PREORDER_INDEX++;
        //Creating the right subtree
        root.setRight(buildTreeFromPreAndPostUtil(preOrder,postOrder,pos+1,postEndIndex));
        return root;

    }

    public TreeNodeInt buildTreeFromInOrderAndPostOrderTraversal(int[] inorder, int[] postOrder){
        POSTORDER_INDEX = postOrder.length-1;
        return buildTreeFromInPostUtil(inorder,postOrder,0,inorder.length-1);

    }

    private TreeNodeInt buildTreeFromInPostUtil(int[] inorder, int[] postOrder, int inStart, int inEnd){
        if(inEnd<inStart){
            return null;
        }
        TreeNodeInt root = new TreeNodeInt(postOrder[POSTORDER_INDEX]);

        if(inStart == inEnd){
            return root;
        }
        int inOrderIndex = findInteger(inorder,postOrder[POSTORDER_INDEX], inStart, inEnd);
        if(inOrderIndex<inEnd){
            POSTORDER_INDEX--;
            root.right = buildTreeFromInPostUtil(inorder,postOrder,inOrderIndex+1,inEnd);
        }
        if(inOrderIndex>inStart){
            POSTORDER_INDEX--;
            root.left = buildTreeFromInPostUtil(inorder,postOrder,inStart,inOrderIndex-1);
        }

        return root;
    }

}
class ListNode{
     int key;
     ListNode next;

    public ListNode(int key) {
        this.key = key;
        next = null;
    }
}