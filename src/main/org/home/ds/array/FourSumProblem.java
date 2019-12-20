package org.home.ds.array;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FourSumProblem {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer,List<IndexPair>> mapping = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                IndexPair obj = new IndexPair(nums[i],nums[j]);
                if(mapping.containsKey(target-obj.getSum())){
                    List<IndexPair> secondObject = mapping.get(target-obj.getSum());
                    List<IndexPair> filteredObject = secondObject.stream()
                            .filter(c->!obj.equals(c))
                            .collect(Collectors.toList());
                    if(filteredObject != null && filteredObject.size()>0){
                        result.addAll(createTuple(obj,filteredObject));
                    }
                }else{
                    List<IndexPair> list = new ArrayList<>();
                    list.add(obj);
                    mapping.put(obj.getSum(),list);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> createTuple(IndexPair obj1, List<IndexPair> list){
        List<List<Integer>> tuples = new ArrayList<>();
        for(IndexPair i : list){
            List<Integer> t = new ArrayList<>();
            t.add(obj1.first);
            t.add(obj1.second);
            t.add(i.first);
            t.add(i.second);
            tuples.add(t);
        }
        return tuples;
    }
}

class IndexPair{
    public int first;
    public int second;
    private int sum;

    public IndexPair(int first, int second){
        this.first = first;
        this.second = second;
        this.sum = first+second;
    }

    public int getSum(){
        return sum;
    }

    @Override
    public boolean equals(Object o){
        if(o ==  null) return false;
        if(getClass() != o.getClass()) return false;
        IndexPair that = (IndexPair)o;
        return (this.first == that.first) &&
                (this.second == that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
