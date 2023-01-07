package BinarySearch;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class OnArraysP1N35 {
    public int bsearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < arr[mid]) {
                right = mid - 1;
            } else if(target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
