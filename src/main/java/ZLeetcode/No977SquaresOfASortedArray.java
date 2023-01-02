package ZLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No977SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sqrtNums = new int[n];
        int left = 0;
        int right = n - 1;
        for(int i = n - 1; i >= 0; --i) {
            int sqrtLeft = nums[left] * nums[left];
            int sqrtRight = nums[right] * nums[right];
            if(sqrtRight > sqrtLeft) {
                sqrtNums[i] = sqrtRight;
                --sqrtRight;
            } else {
                sqrtNums[i] = sqrtLeft;
                ++sqrtLeft;
            }
        }
        return sqrtNums;
    }

    public int[] sortedSquares0(int[] nums) {
        Integer[] sqrtNums = new Integer[nums.length];
        for(int i = 0; i != nums.length; ++i) {
            sqrtNums[i] = nums[i] * nums[i];
        }
        List<Integer> sqrtNumsList = new ArrayList<>(Arrays.asList(sqrtNums));
        Collections.sort(sqrtNumsList);
        return sqrtNumsList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] sortedSquares1(int[] nums) {
        int[] sqrtNums = new int[nums.length];
        for(int i = 0; i != nums.length; ++i) {
            sqrtNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(sqrtNums);
        return sqrtNums;
    }
}
