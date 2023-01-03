package ArraysAndStrings;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * 注意到，正数部分和负数部分，按绝对值，从两端到中间不断减小，可以用两指针比较其两端的大小，
 * 插入新数组，往中间靠近
 */
public class TwoPointersP2N977 {
    public int[] sortedSquaredArr(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            int sqrLeft = nums[left] * nums[left];
            int sqrRight = nums[right] * nums[right];
            if(sqrLeft >= sqrRight) {
                res[i] = sqrLeft;
                left++;
            } else {
                res[i] = sqrRight;
                right--;
            }
        }
        return res;
    }
}
