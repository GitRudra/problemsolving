package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeBuilderTest {

    @Test
    public void buildTreeFromInorderPreOrderTraversal() {
        TreeBuilder builder = new TreeBuilder();
        char in[] = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' };
        builder.printInorder(builder.buildTreeFromInorderPreOrderTraversal(in,pre));
    }

    @Test
    public void testConstructBinaryTreeFromLinkList(){
        int[] input = {36,30,25,15,12,10};
        TreeBuilder builder  = new TreeBuilder();
        ListNode head = builder.createLinkList(input);
        TreeNodeInt root = builder.constructBinaryTreeFromLinkList(head);
        builder.printTree(root);
    }

    @Test
    public void testBuildTreeFromPreAndPostOrderTraversal() throws Exception {
        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        TreeBuilder builder = new TreeBuilder();
        TreeNodeInt root  = builder.buildTreeFromPreAndPostOrderTraversal(pre,post);
        builder.printTree(root); //8 4 9 2 5 1 6 3 7
    }

    @Test
    public void buildTreeFromInOrderAndPostOrderTraversalOne() {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeBuilder builder = new TreeBuilder();
        TreeNodeInt root = builder.buildTreeFromInOrderAndPostOrderTraversal(inorder,postorder);
        builder.printTree(root);
    }

    @Test
    public void buildTreeFromInOrderAndPostOrderTraversalTwo() {
        int[] inorder = {1,2};
        int[] postorder = {1,2};
        TreeBuilder builder = new TreeBuilder();
        TreeNodeInt root = builder.buildTreeFromInOrderAndPostOrderTraversal(inorder,postorder);
        builder.printTree(root);
    }
}