package ArraysAndStrings;

import java.util.Arrays;

/**
 * ou are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k
 * that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * 这一题的主要难点在于浮点和整型的转换
 * 首先不需要每次都计算平均值，最后算一次就行了，只需要随窗口变化和即可
 * 其次，sum直接定义成浮点最好，最后也不用类型转换
 * 如果用整型相除，会遇到精度问题，错误
 * 浮点除以整型也可以，不要忘了left++,其实等于right-k
 */
public class SlidingWindowP1N643 {
    public double maxAvgSubseq(int[] nums, int k) {
        if(k >= nums.length) {
            return Arrays.stream(nums).average().getAsDouble();
        }
        int windowSum = Arrays.stream(nums, 0, k).sum();
        int maxSum = windowSum;
        int left = 0;
        for(int right = k; right < nums.length; right++) {
            windowSum += nums[right] - nums[left];
            maxSum = Math.max(maxSum, windowSum);
            left++;
        }
        return (double)maxSum / (double)k;
    }
}
