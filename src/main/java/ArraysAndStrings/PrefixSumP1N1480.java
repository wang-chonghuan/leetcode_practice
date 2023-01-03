package ArraysAndStrings;

/**
 * Given an array nums. We define a running sum of an array
 * as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 */
public class PrefixSumP1N1480 {
    public int[] runningSum(int[] nums) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        return prefixSums;
    }
}
