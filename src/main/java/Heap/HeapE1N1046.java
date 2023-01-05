package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Example 1: 1046. Last Stone Weight
 *
 * You are given an array of integers stones
 * where stones[i] is the weight of the i-th stone.
 * On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y.
 * If x == y, then both stones are destroyed.
 * If x != y, then x is destroyed and y loses x weight.
 * Return the weight of the last remaining stone, or 0 if there are no stones left.
 *
 * 这题是要从集合中取出两个最大的元素，抵消之后再放回去，直到只剩1个或0个
 * 用优先级队列是最好的方法，因为它的add和remove都是logn复杂度，find是1复杂度
 * 因为需要频繁的入队和出队，用排序数组肯定不行
 */
public class HeapE1N1046 {
    public int findRemainWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int stone : stones) {
            pq.add(stone);
        }
        while(pq.size() >= 2) {
            int max1 = pq.remove();
            int max2 = pq.remove();
            int delta = max1 - max2;
            if(delta > 0) {
                pq.add(delta);
            }
        }
        if(pq.size() == 0) {
            return 0;
        } else {
            return pq.remove();
        }
    }
}
