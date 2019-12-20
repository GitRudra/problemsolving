package org.home.ds.list;

public class ListNode<E> {
    private E key;
    private ListNode<E> next;
    private ListNode<E> random;

    public ListNode(E key) {
        this.key = key;
        this.next = null;
        this.random = null;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getRandom() {
        return random;
    }

    public void setRandom(ListNode<E> random) {
        this.random = random;
    }
}
