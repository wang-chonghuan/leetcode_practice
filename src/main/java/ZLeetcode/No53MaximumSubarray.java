package ZLeetcode;

public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curSubarraySum = nums[0];
        int maxSubarraySum = nums[0];
        for(int i = 1; i != nums.length; ++i) {
            // 如果一个子串是负的,那么它对以后遇到的数,一定是负贡献,所以必须马上抛弃
            if(curSubarraySum < 0) {
                curSubarraySum = nums[i];
            } else { // 如果是正的,可以继续延长,但是只延长当前子串,不延长最大子串
                curSubarraySum += nums[i];
            }
            if(curSubarraySum > maxSubarraySum) {
                maxSubarraySum = curSubarraySum;
            }
        }
        return maxSubarraySum;
    }
}
