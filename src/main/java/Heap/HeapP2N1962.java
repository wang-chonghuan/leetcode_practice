package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1962. Remove Stones to Minimize the Total
 *
 * You are given a 0-indexed integer array piles,
 * where piles[i] represents the number of stones in the ith pile,
 * and an integer k. You should apply the following operation exactly k times:
 *
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
 * Notice that you can apply the operation on the same pile more than once.
 *
 * Return the minimum possible total number of stones remaining
 * after applying the k operations.
 *
 * floor(x) is the greatest integer that is smaller than
 * or equal to x (i.e., rounds x down).
 *
 * 题意：这题是说有piles层石头，每层有几块石头，执行k次操作，每次可以从某层取出一些石头
 * 问如何能让总石头最少
 */
public class HeapP2N1962 {
    public int findMinStones(int[] piles, int k) {
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(var pile : piles) {
            maxHeap.add(pile);
        }
        while(k > 0) {
            double curPileStones = maxHeap.remove();
            int newPileStones = (int) Math.floor(curPileStones / 2);
            maxHeap.add((int)curPileStones - newPileStones);
            k--;
        }
        return maxHeap.stream().mapToInt(i -> i).sum();
    }
}
