package Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 346. Moving Average from Data Stream
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 */
public class QueueP1N346 {
    final private Deque<Integer> dq = new LinkedList<>();
    private int size;
    private double sum;

    public QueueP1N346(int size) {
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        dq.addLast(val);
        sum += val;
        while(dq.size() > size) {
            sum -= dq.removeFirst();
        }
        return sum / dq.size();
    }
}
