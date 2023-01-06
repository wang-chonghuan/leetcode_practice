package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Example 3: 295. Find Median from Data Stream
 *
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, the median is the average of the two middle values.
 *
 * Implement the MedianFinder class:
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num to the data structure.
 * double findMedian() returns the median of all elements so far.
 *
 * 解读题意：让你写一个集合，能往里添加元素，同时返回元素的中位数
 * 简单直觉：用链表ArrayList，让集合排序，每次取中间的数
 * 简单方案的缺点：添加元素的复杂度是o(n)，取中位数的复杂度是o(1)
 * 建议答案：用两个堆，高堆是最小堆，低堆是最大堆，高堆全部比低堆大，
 *      每次添加新数，维持两堆的数量相差不过1
 *      取中位数时，取数量多的堆的堆顶即可，否则取两堆堆顶的平均值
 * 问题在于，如何在add时维持两堆数量符合标准，看注释
 * 新方法的复杂度是o(logn) o(1)
 */
public class HeapE3N295 {
    public class MedianFinder {

        private final PriorityQueue<Integer> highMinHeap
                = new PriorityQueue<>();
        private final PriorityQueue<Integer> lowMaxHeap
                = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder() {
        }
        // add的原理是：只要我每往高堆放一个数，就把高堆的最小数往低堆放（保证了高堆始终比低堆大）
        // 如果低堆比高堆多，就把低堆的最大数往高堆放（保证了高堆比低堆大，同时数量相差不过1）
        // 就一定能让高堆全部比低堆大，同时他们个数相差不到1
        public void addNum(int num) {
            // 把新数放到高堆，高堆的最小数放到低堆
            // 这样有一个问题，如果第一个数放到高堆了，高堆马上把他移到低堆，这样高堆始终是0个数
            highMinHeap.add(num);
            lowMaxHeap.add(highMinHeap.remove());
            // 所以低堆如果数多于高堆，就要把低堆的最大数放入高堆
            if(lowMaxHeap.size() > highMinHeap.size()) {
                highMinHeap.add(lowMaxHeap.remove());
            }
            // 这样第一次个数字add后，高堆有一个数，低堆是0，第二次add后，两个堆各一个数。
            // 避免了都沉淀到低堆。
        }
        public double findMedian() {
            if(highMinHeap.size() > lowMaxHeap.size()) {
                return highMinHeap.peek();
            } else if(highMinHeap.size() < lowMaxHeap.size()) {
                return lowMaxHeap.peek();
            } else {
                return ((double)highMinHeap.peek() + (double)lowMaxHeap.peek()) / 2;
            }
        }
    }
}
