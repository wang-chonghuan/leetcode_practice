package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Example 2: 2208. Minimum Operations to Halve Array Sum
 *
 * You are given an array nums of positive integers.
 * In one operation, you can choose any number from nums
 * and reduce it to exactly half the number.
 * Return the minimum number of operations
 * to reduce the sum of nums by at least half.
 *
 * 给你一个正整数数组，你可以每次选一个数，除以二，放回去
 * 如此操作多次后，数组的和会等于原来的一半，最少操作次数是多少？
 *
 * 直觉告诉我，从大到小依次取除，这样最快，因为每次除掉的最多
 * 就是贪心算法，没有更好的更巧妙的算法时，就用贪心一把梭
 * 大胆使用double，尽早用
 */
public class HeapE2N2208 {
    public int finMinHalves(int[] nums) {
        int cntOps = 0;
        var maxHeap = new PriorityQueue<Double>(Comparator.reverseOrder());
        double sum = 0;
        for(double num : nums) {
            maxHeap.add(num);
            sum += num;
        }
        double half = sum / 2;
        while(half > 0) { // 等于0就不要再减了，再减就小于0了，所以不能写half>=0
            double curHalf = maxHeap.remove() / 2;
            half -= curHalf;
            maxHeap.add(curHalf);
            cntOps++;
        }
        return cntOps;
    }
}
