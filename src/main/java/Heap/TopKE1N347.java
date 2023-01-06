package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Example 1: 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 *
 * 题意：从一个数组中选出频次最高的k个数
 * 用哈希表统计频次是常规操作
 * 简单的想法是，根据哈希表，对频次排序，选出频次最高的k个数
 * 但是其复杂度是o(nlogn)
 * 更好的方法是用最小堆，如果堆中元素大于k，就把堆顶弹出，最后剩下的就是最大的数字
 * 技巧是堆中存放的数字，如何比较大小，参考注释
 *
 * topK的技巧就是，不用排序，而是用堆来统计找到最大的k个数
 * 其复杂度是o(nlogk)，因为你还是要遍历n，但是每次操作只有o(logk)，因为堆的大小是k
 */
public class TopKE1N347 {
    public int[] findTopKFreq(int[] nums, int k) {
        var numFreqMap = new HashMap<Integer, Integer>();
        for(var num : nums) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }
        // 技巧：这个minHeap虽然不放频次，只放数字。
        // 但是数字的排序方式，是参考外部的频次表的
        // 第一次知道这种方法，不仅仅依赖容器内的元素来判断大小
        var numMinHeap = new PriorityQueue<Integer>(
                (a, b) -> (numFreqMap.get(a) - numFreqMap.get(b)));
        for(var num : numFreqMap.keySet()) {
            numMinHeap.add(num);
            if(numMinHeap.size() > k) {
                numMinHeap.remove();
            }
        }
        return numMinHeap.stream().mapToInt(i -> i).toArray();
    }
}
