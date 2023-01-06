package Heap;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Implement KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object
 * with the integer k and the stream of integers nums.
 *
 * int add(int val) Appends the integer val to the stream
 * and returns the element representing the kth largest element in the stream.
 */
public class HeapP1N703 {
    class KthLargest {
        private int[] nums;
        private int k;
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            this.nums = nums;
            this.k = k;
            for(var n : nums) {
                minHeap.add(n);
            }
            while(minHeap.size() > k) {
                minHeap.remove();
            }
        }

        public int add(int val) {
            minHeap.add(val);
            // 因为会出现初始数组为空，其他元素都是后来添加的情况，所以不能每次直接弹出去
            if(minHeap.size() > k) {
                minHeap.remove();
            }
            return minHeap.peek();
        }
    }
}
