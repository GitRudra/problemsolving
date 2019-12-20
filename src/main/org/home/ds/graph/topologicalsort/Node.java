package org.home.ds.graph.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<E>{
    private E value;
    private int index;
    private int inDegreeCount;
    private int outDegreeCount;
    /*private ArrayList<E> inDegree;
    private ArrayList<E> outDegree;*/

    public Node(E value, int index) {
        this.value = value;
        this.index = index;
        this.inDegreeCount = 0;
        this.outDegreeCount = 0;
        /*inDegree = new ArrayList<>();
        outDegree = new ArrayList<>();*/
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getInDegreeCount() {
        return inDegreeCount;
    }

    public void setInDegreeCount(int inDegreeCount) {
        this.inDegreeCount = inDegreeCount;
    }

    public int getOutDegreeCount() {
        return outDegreeCount;
    }

    public void setOutDegreeCount(int outDegreeCount) {
        this.outDegreeCount = outDegreeCount;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void increaseIndegreeCount(){
        inDegreeCount++;
    }

    public void increaseOutDegreeCount(){
        outDegreeCount++;
    }

    public void decreaseInDegreeCount(){
        inDegreeCount--;
    }

    public void decreaseIndegreeCount(){
        outDegreeCount--;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    /* public ArrayList<E> getInDegree() {
        return inDegree;
    }

    public void setInDegree(ArrayList<E> inDegree) {
        this.inDegree = inDegree;
    }

    public ArrayList<E> getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(ArrayList<E> outDegree) {
        this.outDegree = outDegree;
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelOrderTreeNode<?> node = (LevelOrderTreeNode<?>) o;
        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }*/
}
