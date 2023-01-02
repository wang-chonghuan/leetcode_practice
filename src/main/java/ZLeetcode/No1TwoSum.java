package ZLeetcode;

import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {
    public int[] twoSum2(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++i) {
            for(int j = i + 1; j < nums.length; ++j) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap= new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            int complementNum = target - nums[i];
            if(!complementMap.containsKey(complementNum)) {
                complementMap.put(nums[i], i);
                continue;
            } else {
                return new int[]{i, complementMap.get(complementNum)};
            }
        }
        return null;
    }

    public static void test() {
        No1TwoSum c = new No1TwoSum();
        System.out.println(c.twoSum(new int[]{3, 3}, 6).toString());
    }
}
