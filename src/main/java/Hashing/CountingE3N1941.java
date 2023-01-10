package Hashing;

import java.util.HashMap;

/**
 * Example 3: 1941. Check if All Characters Have Equal Number of Occurrences
 *
 * Given a string s, determine if all characters have the same frequency.
 *
 * For example, given s = "abacbc", return true. All characters appear twice.
 * Given s = "aaabb", return false.
 * "a" appears 3 times, "b" appears 2 times. 3 != 2.
 *
 * 标准答案里最后判断values都相等的方法很巧妙
 * Set<Integer> frequencies = new HashSet<>(counts.values());
 *         return frequencies.size() == 1;
 * 判断一组数是否相等,可以把他们放入一个集合里,如果集合元素是1,就相等
 */
public class CountingE3N1941 {
    public boolean areOccurrencesEqual(String s) {
        var charFrqMap = new HashMap<Character, Integer>();
        for(var c : s.toCharArray()) {
            charFrqMap.put(c, charFrqMap.getOrDefault(c, 0) + 1);
        }
        int prev = charFrqMap.values().stream().findFirst().get();
        for(var v : charFrqMap.values()) {
            if(v != prev) {
                return false;
            }
        }
        return true;
    }
}
