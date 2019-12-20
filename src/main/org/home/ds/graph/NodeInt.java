package org.home.ds.graph;

public class NodeInt implements Comparable{
    private int value;
    private int inDegreeCount;
    private int outDegreeCount;

    public NodeInt(int value) {
        this.value = value;
        this.inDegreeCount = 0;
        this.outDegreeCount = 0;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
        return "["+String.valueOf(value)+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInt nodeInt = (NodeInt) o;
        return value == nodeInt.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
