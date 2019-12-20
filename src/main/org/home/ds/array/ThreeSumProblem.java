package org.home.ds.array;

import java.util.*;

public class ThreeSumProblem {

    class Triplet{
        List<Integer> l;

        public Triplet() {
            l = new ArrayList<>();
        }

        public void add(int x){
            l.add(x);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return Objects.equals(l, triplet.l);
        }

        @Override
        public int hashCode() {
            String hash = "";
            for(int x: l){
                hash += String.valueOf(x);
            }
            return hash.hashCode();
//            return Objects.hash(l);
        }
    }

    public List<List<Integer>> findThreeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Triplet> hashSet = new HashSet<>();
        Arrays.sort(num);
        int l = 0;
        int r = 0;
        for(int i=0;i<num.length-2;i++){
            l = i+1;
            r = num.length-1;
            while(l<r){
                if(num[i]+num[l]+num[r] == 0){
                    Triplet triplet = new Triplet();
                    triplet.add(num[i]);
                    triplet.add(num[l]);
                    triplet.add(num[r]);
                    hashSet.add(triplet);
                    l++;
                    r--;
                }else if(num[i]+num[l]+num[r] <0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        hashSet.forEach(e->result.add(e.l));
        return result;

    }


}
