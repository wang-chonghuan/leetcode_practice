package ArraysAndStrings;

/**
 * Example 2: You are given a binary substring s (a string containing only "0" and "1").
 * An operation involves flipping a "0" into a "1".
 * What is the length of the longest substring containing only "1" after performing at most one operation?
 *
 * For example, given s = "1101100111", the answer is 5.
 * If you perform the operation at index 2, the string becomes 1111100111.
 *
 * 固定左端，移动右端，最多让窗口中含有1个0，如果多于1个0，就缩小窗口的左端
 */
public class SlidingWindowE2 {
    public int maxLen1Substr(char[] s) {
        int left = 0;
        int maxLen = 0;
        int count0 = 0;
        for(int right = 0; right < s.length; right++) { // 移动右端
            if(s[right] == '0') { // 如果遇到0，就增加计数
                count0++;
            }
            while(count0 > 1) { // 如果0超标，就移动左端
                if(s[left] == '0') { // 移动左端前，如果左端是0，应该把减少计数
                    count0--;
                }
                left++; // 然后再移动左端
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
