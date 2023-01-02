package ZLeetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No217ContainsDuplicate {
    // sort
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i != nums.length - 1; ++i) {
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // hashtable
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>(nums.length);
        for(int e: nums) {
            if(numsSet.contains(e)) {
                return true;
            } else {
                numsSet.add(e);
            }
        }
        return false;
    }
}
