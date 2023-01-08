package Hashing;

import java.util.HashSet;

/**
 * 268. Missing Number
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class CheckExistP2N268 {
    public int missingNumber(int[] nums) {
        var numSet = new HashSet<Integer>();
        for(var num : nums) {
            numSet.add(num);
        }
        for(int i = 0; i <= nums.length; i++) {
            if(!numSet.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
