package ArraysAndStrings;

/**
 * Example 2: Given a sorted array of unique integers and a target integer,
 * return true if there exists a pair of numbers that sum to target,
 * false otherwise. This problem is similar to Two Sum.
 *
 * For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13,
 * return true because 4 + 9 = 13.
 */
public class TwoPointersE2 {
    public boolean existsPairSumToTar(int[] nums, int tar) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int curSum = nums[left] + nums[right];
            if(curSum == tar) {
                return true;
            }
            if(curSum > tar) {
                right--;
                continue;
            }
            if(curSum < tar) {
                left++;
                continue;
            }
        }
        return false;
    }
}
