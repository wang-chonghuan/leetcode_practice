package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Example 3: Given an integer array nums,
 * find all the numbers x that satisfy the following:
 * x + 1 is not in nums, and x - 1 is not in nums.
 */
public class CheckExistE3 {
    public List<Integer> findXs(int[] nums) {
        var numSet = new HashSet<Integer>();
        List<Integer> res = new ArrayList<>();
        for(var num : nums) {
            numSet.add(num);
        }
        for(var num : nums) {
            if(!numSet.contains(num - 1) && !numSet.contains(num + 1)) {
                res.add(num);
            }
        }
        return res;
    }
}
