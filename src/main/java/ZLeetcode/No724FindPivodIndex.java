package ZLeetcode;

import java.util.Arrays;

public class No724FindPivodIndex {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int rightSum = sum - nums[0];
        if(leftSum == rightSum)
            return 0;
        int pivot = 1;
        while(pivot < nums.length) {
            leftSum += nums[pivot - 1];
            rightSum -= nums[pivot];
            if(leftSum == rightSum) {
                return pivot;
            } else {
                ++pivot;
            }
        }
        return -1;
    }
}
