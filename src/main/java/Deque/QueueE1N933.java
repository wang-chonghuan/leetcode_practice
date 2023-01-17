package Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 933. Number of Recent Calls
 *
 * Implement the QueueE1N933 class.
 * It should support ping(int t), which records a call at time t,
 * and then returns an integer representing the number of calls
 * that have happened in the range [t - 3000, t].
 * Calls to ping will have increasing t.
 */
public class QueueE1N933 {
    final Deque<Integer> dq = new LinkedList<>();

    public QueueE1N933() {

    }

    public int ping(int t) {
        while(dq.size() > 0 && dq.getFirst() < t - 3000) {
            dq.removeFirst();
        }
        dq.addLast(t);
        return dq.size();
    }
}
