package org.home.ds.special;

import java.util.HashSet;
import java.util.LinkedList;


/**
 * How to implement LRU caching scheme?
 * What data structures should be used?
 * We are given total possible page numbers that can be referred.
 * We are also given cache (or memory) size
 * (Number of page frames that cache can hold at a time).
 * The LRU caching scheme is to remove the least recently used frame
 * when the cache is full and
 * a new page is referenced which is not there in cache
 * @param <T>
 */
public class LRUCache<T> {
    private LinkedList<T> data;
    private HashSet<T> pageHash;
    private int capacity;

    public LRUCache(int capacity) {
        data = new LinkedList<>();
        pageHash = new HashSet<>(capacity);
        this.capacity = capacity;
    }

    public void findFromCache(T key){
        if(!pageHash.contains(key)){
            if(data.size()==capacity){
                T temp = data.removeLast();
                data.addFirst(key);
                pageHash.remove(temp);
                pageHash.add(key);
            }else{
                //data.remove(key);
                data.addFirst(key);
                pageHash.add(key);
            }
        }else{
            data.remove(key);
            data.addFirst(key);
            pageHash.add(key);
        }
        printCache();
    }

    public void printCache(){
        System.out.println(data);
    }
}
