package ArraysAndStrings;

/**
 * Given an array of integers nums,
 * you start with an initial positive value startValue.
 *
 * In each iteration, you calculate the step by step
 * sum of startValue plus elements in nums (from left to right).
 *
 * Return the minimum positive value of startValue
 * such that the step by step sum is never less than 1.
 *
 * 这题的难点在于，首先不要忽略0元素，所以要用两次循环，
 * 应该用max，而不是min
 * 正pre不影响starter，只有负pre会让starter变大，最大就是刚好能抵消负pre的数，所以用max
 */
public class PrefixSumP2N1413 {
    public int minStartValue(int[] nums) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        int minStarter = 1;
        for(int pre : prefixSums) {
            if(pre < 0) {
                minStarter = Math.max(-1 * pre + 1, minStarter);
            }
        }
        return minStarter;
    }
}
