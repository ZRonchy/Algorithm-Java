package leetcode.greedyalgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of jobs where every job has a deadline and associated profit
 * if the job is finished before the deadline. It is also given that every job
 * takes single unit of time, so the minimum possible deadline for any job is 1.
 * How to maximize total profit if only one job can be scheduled at a time.
 * Input:  Five Jobs with following deadlines and profits
 * JobID     Deadline     Profit
 * a         2           100
 * b         1           19
 * c         2           27
 * d         1           25
 * e         3           15
 * Output: Following is maximum profit sequence of jobs
 * c, a, e
 * <p>
 * Solution
 * 1) Sort all jobs in decreasing order of profit. If twoor more jobs are having the
 * same profit then sort them as per their entry in the job list.
 * 2) Initialize the result sequence as first job in sorted jobs.
 * 3) Do following for remaining n-1 jobs
 * .......a) If the current job can fit in the current result sequence
 * without missing the deadline, add current job to the result.
 * Else ignore the current job.4
 * <p>
 * Suppose that a job J1 has a deadline of time t = 5. We assign the greatest time slot which is free
 * and less than the deadline i.e 4-5 for this job. Now another job J2 with deadline of 5 comes in, so
 * the time slot allotted will be 3-4 since 4-5 has already been allotted to job J1
 */
public class JobSequencing {
    // schedule jobs to maximize profit
    public static int scheduleJobs(List<Job> jobs, int T) {
        // stores maximum profit that can be earned by scheduling jobs
        int profit = 0;

        // array to store used and unused slots info
        int[] slot = new int[T];
        Arrays.fill(slot, -1);

        // consider each job in decreasing order of their profits
        for (Job job : jobs) {
            // search for next free slot and map the task to that slot
            for (int j = job.getDeadline() - 1; j >= 0; j--) {
                if (j < T && slot[j] == -1) {
                    slot[j] = job.getTaskID();
                    profit += job.getProfit();
                    break;
                }
            }
        }

        // print the scheduled jobs
        System.out.println("The Scheduled jobs are - ");
        Arrays.stream(slot)            // Java 8 Streams
                .filter(val -> val != -1)
                .forEach(System.out::println);

        // return total profit that can be earned
        return profit;
    }

    public static void main(String[] args) {
        // List of given jobs. Each job has an identifier, a deadline and
        // profit associated with it
        List<Job> jobs = Arrays.asList(
                new Job(1, 9, 15), new Job(2, 2, 2),
                new Job(3, 5, 18), new Job(4, 7, 1),
                new Job(5, 4, 25), new Job(6, 2, 20),
                new Job(7, 5, 8), new Job(8, 7, 10),
                new Job(9, 4, 12), new Job(10, 3, 5)
        );

        // stores maximum deadline that can be associated with a job
        final int T = 15;

        // arrange the jobs in decreasing order of their profits
        Collections.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());

        // schedule jobs and calculate maximum profit
        System.out.println("\nTotal Profit is: " + scheduleJobs(jobs, T));
    }
}

class Job {
    private int taskID, deadline, profit;

    public Job(int taskID, int deadline, int profit) {
        this.taskID = taskID;
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getProfit() {
        return profit;
    }

    public int getTaskID() {
        return taskID;
    }
}