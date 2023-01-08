package Hashing;

import java.util.HashMap;

/**
 * 1426. Counting Elements
 * Given an integer array arr, count how many elements x there are,
 * such that x + 1 is also in arr.
 * If there are duplicates in arr, count them separately.
 */
public class CheckExistP3N1426 {
    public int countElements(int[] arr) {
        int cnt = 0;
        var eleFreqMap = new HashMap<Integer, Integer>();
        for(var ele : arr) {
            eleFreqMap.put(ele, eleFreqMap.getOrDefault(ele, 0) + 1);
        }
        for(var e : arr) {
            if(eleFreqMap.containsKey(e) && eleFreqMap.containsKey(e + 1)) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
