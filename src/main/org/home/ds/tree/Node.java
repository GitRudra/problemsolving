package org.home.ds.tree;

public class Node<T> {
    private T element;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private boolean leafNode;

    public Node(T element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
        leafNode = true;
    }

    /*public LevelOrderTreeNode() {
        //this.element = element;
        leftChild = null;
        rightChild = null;
        leafNode = true;
    }*/

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
        if(this.leftChild != null){
            leafNode = false;
        }
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
        if(this.rightChild != null){
            leafNode = false;
        }
    }

    public boolean isLeafNode() {
        return leafNode;
    }

    public void setLeafNode(boolean leafNode) {
        this.leafNode = leafNode;
    }

    public boolean hasLeftChild(){
        return (leftChild != null);
    }

    public boolean hasRightChild(){
        return (rightChild != null);
    }


}
