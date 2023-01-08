package Hashing;

import java.util.*;

/**
 * Example 1: 1. Two Sum
 *
 * Given an array of integers nums and an integer target,
 * return indices of two numbers such that they add up to target.
 * You cannot use the same index twice.
 *
 * 只用一次循环的原理是,补数是相互的,即使A的补数B还没插入map,后面插B的时候,会去找A,找到A就互补了
 * 而且不用处理AB下标一样的问题,因为不可能一样
 */
public class CheckExistE1N1 {
    public int[] twoSum(int[] nums, int target) {
        var numIndexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++) {
            int another = target - nums[j];
            if(numIndexMap.containsKey(another)) {
                int anotherIndex = numIndexMap.get(another);
                if(anotherIndex != j) {
                    return new int[]{j, anotherIndex};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumSTD(int[] nums, int target) {
        var numIndexMap = new HashMap<Integer, Integer>();
        for(int j = 0; j < nums.length; j++) {
            int another = target - nums[j];
            if(numIndexMap.containsKey(another)) {
                int anotherIndex = numIndexMap.get(another);
                return new int[]{j, anotherIndex};
            }
            numIndexMap.put(nums[j], j);
        }
        return new int[]{-1, -1};
    }
}
