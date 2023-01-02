package ArraysAndStrings;

/**
 * Example 3: 713. Subarray Product Less Than K.
 *
 * Given an array of positive integers nums and an integer k,
 * return the number of contiguous subarrays
 * where the product of all the elements in the subarray is strictly less than k.
 *
 * 在任何right，固定right，都会有一个最长的subarr，这个最长的subarr的长度的数值，就是这个right所有的subarr的数量
 * 加总这些数量，就是最终答案
 * 还是用滑动窗口的方法，不断扩张right，如果超标，就缩小left，这个标，就是窗口里元素的乘积
 * 每次扩张right的时候，就乘上新的right，如果超标，缩小left的时候，就把老的left除掉
 * 此时针对新的窗口，窗口中的所有元素，都满足乘积条件，因此算出这个窗口有几个子串就可以
 * 只计算以right为右端点的子串数量，这样才不会重复，因为每个子串都包含该右端点，其他窗口一定不会包含这个子串
 * 那么以右端点为端点，一共有多少个子串呢？这个数值，就是窗口的长度。
 * 其实很容易理解，ABCD，必须包含D，固定子串是：D,CD,BCD,ABCD，四个，刚好高等于ABCD的长度
 *
 */
public class SlidingWindowE3N713 {
    public int lcNumSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1;
        int numSubarr = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while(prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            numSubarr += (right - left + 1);
        }
        return numSubarr;
    }
}
