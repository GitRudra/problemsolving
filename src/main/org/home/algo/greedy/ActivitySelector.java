package org.home.algo.greedy;

import java.util.*;

/**
 * You are given n activities with their start and finish times.
 * Select the maximum number of activities that can be
 * performed by a single person, assuming that a person
 * can only work on a single activity at a time.
 *
 * Example 1 : Consider the following 3 activities sorted by finish time.
 *      start[]  =  {10, 12, 20};
 *      finish[] =  {20, 25, 30};
 * A person can perform at most two activities. The maximum set of activities
 * that can be executed is {0, 2} [ These are indexes in start[] and finish[] ]
 *
 * Example 2 : Consider the following 6 activities
 * sorted by by finish time.
 *      start[]  =  {1, 3, 0, 5, 8, 5};
 *      finish[] =  {2, 4, 6, 7, 9, 9};
 * A person can perform at most four activities. The
 * maximum set of activities that can be executed
 * is {0, 1, 3, 4} [ These are indexes in start[] and
 * finish[] ]
 */

public class ActivitySelector {
    private ArrayList<Activity> activities;

    /**
     * Default constructor
     */
    public ActivitySelector() {
        this.activities = new ArrayList<>();
    }

    /**
     * Comparator class to compare two activity based on their end time
     */
    /*class ActivityComparator implements Comparator<Activity>{

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.getEnd().compareTo(o2.getEnd());
        }
    }*/

    public void addActivity(int start, int end){
        activities.add(new Activity(start,end));
    }

    /**
     * The greedy choice is to always pick the next activity whose
     * finish time is least among the remaining activities and
     * the start time is more than or equal to the finish time of
     * previously selected activity. We can sort the activities according to
     * their finishing time so that we always consider the next
     * activity as minimum finishing time activity.
     *
     * 1) Sort the activities according to their finishing time
     * 2) Select the first activity from the sorted array and print it.
     * 3) Do following for remaining activities in the sorted array.
     * …….a) If the start time of this activity is greater than or equal to the finish time
     * of previously selected activity then select this activity and print it.
     * @return
     */
    public List selectActivities(){
        if(activities == null || activities.size()==0){
            return Collections.EMPTY_LIST;
        }
        Collections.sort(activities,(o1,o2)->o1.getEnd().compareTo(o2.getEnd()));
        List<Activity> result = new ArrayList<>();

        Iterator<Activity> it  = activities.iterator();
        result.add(it.next());
        while(it.hasNext()){
            Activity activityObj = it.next();
            if(activityObj.getStart()>=result.get(result.size()-1).getEnd()){
                result.add(activityObj);
            }
        }
        return result;
    }

}

/**
 * Class to represent a single activity
 */
class Activity{
    private Integer start;
    private Integer end;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(start, activity.start) &&
                Objects.equals(end, activity.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    public Activity(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }
}