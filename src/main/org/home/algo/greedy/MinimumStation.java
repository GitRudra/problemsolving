package org.home.algo.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class MinimumStation {
    public int findMinimumStation(int[] arrival, int[] departure){
        if(arrival == null || arrival.length == 0 || departure == null || departure.length == 0){
            return -1;
        }
        if(arrival.length != departure.length){
            return -1;
        }
        ArrayList<TrainSchedule> schedule = new ArrayList<>();
        for(int i = 0;i<arrival.length;i++){
            schedule.add(new TrainSchedule(arrival[i],departure[i]));
        }

        schedule.sort((o1,o2)-> Integer.compare(o1.getDeparture(), o2.getDeparture()));

        int stationCount = 1;
        Iterator<TrainSchedule> it = schedule.iterator();
        TrainSchedule lastSchedule = it.next();

        while(it.hasNext()){
            TrainSchedule nextSchedule = it.next();
            if(nextSchedule.getArrival() < lastSchedule.getDeparture()){
                stationCount++;
            }
            lastSchedule = nextSchedule;
        }

        return stationCount-1;

    }
}

class TrainSchedule{
    private int arrival;
    private int departure;

    public TrainSchedule(int arrival, int departure){
        this.arrival = arrival;
        this.departure = departure;
    }

    /*@Override
    public int hashCode(){
        return Objects.hash(arrival,departure);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TrainSchedule that = (TrainSchedule) o;
        return (this.arrival == that.arrival) && (this.departure == that.departure);
    }*/

    public int getArrival(){
        return arrival;
    }

    public int getDeparture(){
        return departure;
    }
}
