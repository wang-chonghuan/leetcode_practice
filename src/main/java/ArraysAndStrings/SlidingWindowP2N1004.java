package ArraysAndStrings;

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 *
 * 这个方法同SlidingWindowE2，注意是数字，不是字符，不要写成‘1’,‘0’
 */
public class SlidingWindowP2N1004 {
    public int WRONGmaxLenOf1WithK0(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int count0 = 0;
        for(right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                count0++;
            }
            if(count0 > k) {
                if(nums[left] == 0) {
                    count0--;
                }
                left++;
            }
        }
        return right - left;
    }
}
