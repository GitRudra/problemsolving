package org.home.algo.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class SkyLineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int noOfBuildings = buildings.length;
        List<BuildingPoint> buildingPoints = new ArrayList<>();
        for(int i = 0;i<noOfBuildings;i++){
            BuildingPoint pointStart = new BuildingPoint(buildings[i][0],true,buildings[i][2]);
            buildingPoints.add(pointStart);
            BuildingPoint pointEnd = new BuildingPoint(buildings[i][1],false,buildings[i][2]);
            buildingPoints.add(pointEnd);

        }

        Collections.sort(buildingPoints);
        TreeMap<Integer,Integer> queue = new TreeMap<>();
        int prevMaxHeight = 0;
        queue.put(0,1);
        List<List<Integer>> result = new ArrayList<>();

        for(BuildingPoint point : buildingPoints){
            if(point.isStart){
                if(queue.containsKey(point.height)){
                    queue.put(point.height,queue.get(point.height)+1);
                }else{
                    queue.put(point.height,1);
                }
            }else{
                if(queue.containsKey(point.height)){
                    int c = queue.get(point.height);
                    if(c == 1){
                        queue.remove(point.height);
                    }else{
                        queue.put(point.height,queue.get(point.height)-1);
                    }

                }
            }
            int currentMaxHeight = queue.lastKey();
            if(prevMaxHeight != currentMaxHeight){
                ArrayList<Integer> res = new ArrayList();
                res.add(point.x);
                res.add(currentMaxHeight);
                result.add(res);
                prevMaxHeight = currentMaxHeight;
            }

        }
        return result;
    }
}

class BuildingPoint implements Comparable<BuildingPoint> {

    public int x;
    public boolean isStart;
    public int height;

    public BuildingPoint(int x, boolean isStart, int height) {
        this.x = x;
        this.isStart = isStart;
        this.height = height;
    }

    @Override
    public int compareTo(BuildingPoint o) {
        //first compare by x.
        //If they are same then use this logic
        //if two starts are compared then higher height building should be picked first
        //if two ends are compared then lower height building should be picked first
        //if one start and end is compared then start should appear before end
        if (this.x != o.x) {
            return this.x - o.x;
        } else {
            return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
        }
    }
}
