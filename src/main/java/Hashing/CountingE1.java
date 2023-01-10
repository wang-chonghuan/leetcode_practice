package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Example 1: You are given a string s and an integer k.
 * Find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "eceba" and k = 2, return 3.
 * The longest substring with at most 2 distinct characters is "ece".
 *
 * 这题的难点在于,为什么不能用set
 * 比如eceb 2
 * 读到b时,删除第一个e,如果是集合,会从ec集合里把e删掉,就不对了,因为还有一个e
 * 所以必须要用map,来保存每个字符的频次
 *
 */
public class CountingE1 {

    public int maxLenSubWKCharMost(String s, int k) {
        var charFreqMap = new HashMap<Character, Integer>();
        int left = 0, right = 0, ans = 0;
        for(right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
            while(charFreqMap.size() > k) {
                Character cLeft = s.charAt(left);
                int freqLeft = charFreqMap.get(cLeft);
                if(freqLeft == 1) {
                    charFreqMap.remove(cLeft);
                } else {
                    charFreqMap.put(cLeft, freqLeft - 1);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int maxLenSubWKCharMostWRONG(String s, int k) {
        var distinctSet = new HashSet<Character>();
        int left = 0;
        int right = 0;
        for(right = 0; right < s.length(); right++) {
            distinctSet.add(s.charAt(0));
            while(distinctSet.size() > k) {
                left += 1;
                distinctSet.remove(s.charAt(left));
            }
        }
        return right - left + 1;
    }
}

