package org.home.ds.special;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void testFindFromCache() {
        int cacheSixe = 4;
        LRUCache<Integer> intCache = new LRUCache<>(cacheSixe);
        int input[] = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        for(int i=0;i<input.length;i++){
            intCache.findFromCache(input[i]);
        }

        intCache.printCache();
    }
}