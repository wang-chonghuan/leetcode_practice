package BinarySearch;

/**
 * Example 1: 704. Binary Search
 *
 * You are given an array of integers nums which is sorted in ascending order,
 * and an integer target. If target exists in nums, return its index.
 * Otherwise, return -1.
 */
public class OnArraysE1N704 {
    public int findTar(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < nums[mid]) {
                right = mid - 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
