package Hashing;

import java.util.*;

/**
 * Given a 2D array nums that contains n arrays of distinct integers,
 * return a sorted array containing all the numbers that appear in all n arrays.
 *
 * For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]],
 * return [3, 4].
 * 3 and 4 are the only numbers that are in all arrays.
 */
public class CountingE2N2248 {
    public List<Integer> intersection(int[][] nums) {
        var ret = new ArrayList<Integer>();
        var numFrqMap = new HashMap<Integer, Integer>();
        for(int i  = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                numFrqMap.put(nums[i][j],
                        numFrqMap.getOrDefault(nums[i][j], 0) + 1);
            }
        }
        for(int num : numFrqMap.keySet()) {
            int frq = numFrqMap.get(num);
            if(frq == nums.length) {
                ret.add(num);
            }
        }
        Collections.sort(ret);
        return ret;
    }
}
