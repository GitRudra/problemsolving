package org.home.ds.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedArray {

    public List<Integer> mergeKSortedArray(List<List<Integer>> kIntegerArray, int k, int n) throws Exception {
        class HeapObj {
            Integer value;
            Integer arrayIndex;
            Integer arrayCurrentIndex;

            public HeapObj(Integer value, Integer arrayIndex, Integer arrayCurrentIndex) {
                this.value = value;
                this.arrayIndex = arrayIndex;
                this.arrayCurrentIndex = arrayCurrentIndex;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }

            public Integer getArrayIndex() {
                return arrayIndex;
            }

            public void setArrayIndex(Integer arrayIndex) {
                this.arrayIndex = arrayIndex;
            }

            public Integer getArrayCurrentIndex() {
                return arrayCurrentIndex;
            }

            public void setArrayCurrentIndex(Integer arrayCurrentIndex) {
                this.arrayCurrentIndex = arrayCurrentIndex;
            }
        }

        /*Heap<HeapObj> heap = new Heap<HeapObj>(HeapObj.class, k, new Comparator<HeapObj>() {
            @Override
            public int compare(HeapObj o1, HeapObj o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });*/

        Heap<HeapObj> heap = new Heap<HeapObj>(k, new Comparator<HeapObj>() {
            @Override
            public int compare(HeapObj o1, HeapObj o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        /*for (int i = 0; i < k; i++) {
            heap.addElement(new HeapObj(kIntegerArray.get(i).get(0), i, 0));
        }*/
        for (int i = 0; i < k; i++) {
            heap.insert(new HeapObj(kIntegerArray.get(i).get(0), i, 0));
        }

        List<Integer> resultList = new ArrayList<>();
        while (heap.size() > 0) {
            HeapObj obj = heap.getTop();
            resultList.add(obj.getValue());
            if (obj.getArrayCurrentIndex() < n) {
                obj.setValue(kIntegerArray.get(obj.getArrayIndex()).get(obj.getArrayCurrentIndex() + 1));
                obj.setArrayCurrentIndex(obj.getArrayCurrentIndex() + 1);
            }

        }

        return resultList;

    }
}
