package BinarySearch;

import java.util.Arrays;

/**
 * 2389. Longest Subsequence With Limited Sum
 *
 * You are given an integer array nums of length n,
 * and an integer array queries of length m.
 *
 * Return an array answer of length m
 * where answer[i] is the maximum size of a subsequence
 * that you can take from nums
 * such that the sum of its elements is less than or equal to queries[i].
 *
 * A subsequence is an array that can be derived from another array
 * by deleting some or no elements without changing the order of the remaining elements.
 *
 * 题意:两个数组nums和queries,返回一个数组res,其中每个元素,是queries对应的查询结果
 * 该结果,是nums的子序列最大长度,要满足子序列元素之和小于等于queries的对应元素
 *
 * 分析:要让子序列最长,就尽量选小的,只要小的累加起来,小于等于limit即可
 * 对nums排序,再算前序和,再做二分查找limit
 */
public class OnArraysP2N2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        // 排序
        Arrays.sort(nums);
        // 计算前序和
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        // 对每个limit做二分查找
        int[] answer = new int[m];
        for(int i = 0; i < m; i++) {
            answer[i] = bsearch(prefixSum, queries[i]);
        }
        return answer;
    }
    private int bsearch(int[] nums, int limit) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(limit < nums[mid]) {
                right = mid - 1;
            } else if(limit > nums[mid]) {
                left = mid + 1;
            } else {
                // 观察case发现如果刚好等于limit时计数少了一个,于是这里加1
                // 因为这个是下标的位置,真实长度就是下标加1
                return mid + 1;
            }
        }
        return left;
    }
}
