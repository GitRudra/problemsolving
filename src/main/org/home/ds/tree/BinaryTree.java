package org.home.ds.tree;

public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public BinaryTree() {
//        this.root = root;
    }

    /*public LevelOrderTreeNode<T> getNode(T element){
        return new LevelOrderTreeNode(element);
    }*/

    public Node<T> getRoot() {
        return root;
    }
}
