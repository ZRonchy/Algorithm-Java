package leetcode.stringarray;

import java.util.LinkedList;

/**
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {
    private int size;

    private LinkedList<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int value) {
        if (queue.size() == size) {
            queue.poll();
        }

        queue.add(value);
        return loopQueue();
    }

    private double loopQueue() {
        int sum = 0;
        for (int num: queue) {
            sum = sum + num;
        }

        return (double) sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
