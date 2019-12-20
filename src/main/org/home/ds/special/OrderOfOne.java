package org.home.ds.special;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Design a data structure that supports following operations in Θ(1) time.
 * insert(x): Inserts an item x to the data structure if not already present.
 * remove(x): Removes an item x from the data structure if present.
 * search(x): Searches an item x in the data structure.
 * getRandom(): Returns a random element from current set of elements
 *
 * We can use hashing to support first 3 operations in Θ(1) time.
 * How to do the 4th operation? The idea is to use a resizable array
 * (ArrayList in Java, vector in C) together with hashing.
 * Resizable arrays support insert in Θ(1) amortized time complexity.
 * To implement getRandom(), we can simply pick a random number from 0 to
 * size-1 (size is number of current elements) and
 * return the element at that index.
 * The hash map stores array values as keys and array indexes as values.
 * @param <T>
 */
public class OrderOfOne<T> {

    //Stores the actual data.
    ArrayList<T> dataStore;
    //Store the index of each data in the datastore.
    // The hashmap will be used for look up
    HashMap<T, Integer> dataMap;
    //Counts the number of data in the datastore
    Integer COUNTER;
    //Generate the randome number
    Random randomGenerator;

    public OrderOfOne() {
        dataStore = new ArrayList<>();
        dataMap = new HashMap<>();
        COUNTER = 0;
        randomGenerator = new Random();
    }


    /**
     * <ol>
     *     <li>Check if x is already present by doing a hash map lookup</li>
     *     <li>If not present, then insert it at the end of the array.</li>
     *     <li>Add in hash table also, x is added as key and last array index as index.</li>
     * </ol>
     * @param key the element to be inserted into the key.
     */
    public void insert(T key){
        if(!dataMap.containsKey(key)){
            dataStore.add(COUNTER,key);
            dataMap.put(key,COUNTER);
            COUNTER++;
        }
    }

    /**
     * Search the element into the lookup map.
     * @param key the element need to be searched
     * @return the element if present.
     * @throws Exception if the element not found in the data store.
     */
    public T search(T key) throws Exception {
        if(dataMap.containsKey(key)){
            return dataStore.get(dataMap.get(key));
        }else{
            throw new Exception("Key not found");
        }
    }

    public void delete(T key) throws Exception {
        if(dataMap.containsKey(key)){
            Integer searchIndex = dataMap.get(key);
            if(searchIndex == COUNTER-1){
                dataMap.remove(key);
                dataStore.remove(COUNTER-1);
            }else{
                dataMap.remove(key);
                T last = dataStore.get(COUNTER-1);
                Collections.swap(dataStore,searchIndex,COUNTER-1);
                dataStore.remove(COUNTER-1);
                dataMap.put(last,searchIndex);
            }

            COUNTER--;
        }else{
            throw new Exception("Key not found");
        }
    }

    public T getRandom(){
        return dataStore.get(randomGenerator.nextInt(COUNTER));
    }
}
