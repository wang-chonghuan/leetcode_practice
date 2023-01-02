package ZLeetcode;

public class No1480RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] runningSum = new int[len];
        int previousSum = 0;
        for(int i = 0; i < len; ++i) {
            int currentSum = previousSum + nums[i];
            runningSum[i] = currentSum;
            previousSum = currentSum;
        }
        return runningSum;
    }
}
