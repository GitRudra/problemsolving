package org.home.ds.tree;

import org.junit.Test;

public class TreeTravellerTest {

    @Test
    public void inorderTraversalWithoutRecursion() {
        TreeTraveller<Integer> traveller = new TreeTraveller();
        Node<Integer> root = new Node<>(1);
        BinaryTree<Integer> btree = new BinaryTree<>(root);
        btree.getRoot().setLeftChild(new Node(2));
        btree.getRoot().setRightChild(new Node(3));
        btree.getRoot().getLeftChild().setLeftChild(new Node(4));
        btree.getRoot().getLeftChild().setRightChild(new Node(5));
        System.out.println(traveller.inorderTraversalWithoutRecursion(btree));
    }

    @Test
    public void testLeftViewOfTreeOne(){
        TreeNodeInt root = createTree();
        TreeTraveller<Integer> traveller = new TreeTraveller();
        traveller.leftViewBinaryTree(root);

    }

    private TreeNodeInt createTree(){
        TreeNodeInt tree = new TreeNodeInt(9);
        tree.setLeft(new TreeNodeInt(4));
        tree.setRight(new TreeNodeInt(12));
        tree.getLeft().setLeft(new TreeNodeInt(2));
        tree.getLeft().setRight(new TreeNodeInt(6));
        tree.getRight().setLeft(new TreeNodeInt(10));
        tree.getRight().setRight(new TreeNodeInt(14));
        return  tree;
    }
}