package Heap;

import java.util.PriorityQueue;

/**
 * 1167. Minimum Cost to Connect Sticks
 * You have some number of sticks with positive integer lengths.
 * These lengths are given as an array sticks,
 * where sticks[i] is the length of the ith stick.
 *
 * You can connect any two sticks of lengths x and y
 * into one stick by paying a cost of x + y.
 * You must connect all the sticks until there is only one stick remaining.
 *
 * Return the minimum cost of connecting all the given sticks
 * into one stick in this way.
 *
 * 题意：有很多长度不同的木棍，可以把两根接起来，费用是两根的长度之和
 * 按什么顺序接，把他们接完，总费用最少。
 * 想象一个例子：1，1，1，10四根木棍，我先接1和10是11，再接11和1是12，再接12和1是13
 * 加起来总费用是11+12+13=36
 * 如果我先接短的：1和1是2，2和1是3，3和10是13，总费用是2+3+13=18
 * 所以方法是用一个最小堆
 */

public class HeapP3N1167 {
    public int minCost(int[] sticks) {
        var minHeap = new PriorityQueue<Integer>();
        for(var s : sticks) {
            minHeap.add(s);
        }
        int cost = 0;
        while(minHeap.size() > 1) {
            int min1 = minHeap.remove();
            int min2 = minHeap.remove();
            cost += min1 + min2;
            minHeap.add(min1 + min2);
        }
        return cost;
    }
}
