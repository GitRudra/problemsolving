package org.home.algo.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


/**
 * Given an array of jobs where every job has a deadline and
 * associated profit if the job is finished before the deadline.
 * It is also given that every job takes single unit of time,
 * so the minimum possible deadline for any job is 1.
 * How to maximize total profit if only one job can be scheduled at a time.
 *
 * Examples:
 *
 * Input: Four Jobs with following
 * deadlines and profits
 * JobID  Deadline  Profit
 *   a      4        20
 *   b      1        10
 *   c      1        40
 *   d      1        30
 * Output: Following is maximum
 * profit sequence of jobs
 *         c, a
 *
 *
 * Input:  Five Jobs with following
 * deadlines and profits
 * JobID   Deadline  Profit
 *   a       2        100
 *   b       1        19
 *   c       2        27
 *   d       1        25
 *   e       3        15
 * Output: Following is maximum
 * profit sequence of jobs
 *         c, a, e
 */
public class JobScheduling {
    public void scheduleJob(String[] ids, int[] deadLines, int[] profits){
        ArrayList<JobInstance> jobListing = new ArrayList<>();
        ArrayList<JobInstance> jobSequence = new ArrayList<>();
        for(int i=0;i<ids.length;i++){
            jobListing.add(new JobInstance(ids[i],deadLines[i],profits[i]));
        }

        jobListing.sort((o1,o2)-> Integer.compare(o2.getProfit(),o1.getProfit()));
        Iterator<JobInstance> it = jobListing.iterator();
        jobSequence.add(it.next());
        while(it.hasNext()){
            JobInstance job = it.next();
            if(job.getDeadline() > jobSequence.size()){
                jobSequence.add(job);
            }
        }

        System.out.println(jobSequence);
    }
}

class JobInstance{
    private String jobId;
    private int deadline;
    private int profit;

    public JobInstance(String jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobInstance that = (JobInstance) o;
        return deadline == that.deadline &&
                profit == that.profit &&
                Objects.equals(jobId, that.jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, deadline, profit);
    }*/

    @Override
    public String toString() {
        return "JobInstance{" +
                "jobId='" + jobId + '\'' +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}
