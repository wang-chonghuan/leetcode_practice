package ArraysAndStrings;

/**
 * Example 4: 392. Is Subsequence.
 *
 * Given two strings s and t, return true if s is a subsequence of t,
 * or false otherwise.
 *
 * A subsequence of a string is a new string that is formed
 * from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions
 * of the remaining characters. The fact that they aren't consecutive doesn't matter
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * 双指针，同时遍历两字符串，如果s的指针对应的字符，等于t的指针对应的字符，那么去匹配下一个s
 * 如果不等于，s指针不变，只移动t指针，去看下一个t是否能匹配上
 * 关键在于，有一个字符串遍历完，整个就遍历完了，不需要继续遍历了
 * 如果s字符串彻底遍历完，说明全部匹配了，那么就子串匹配成功了
 */
public class TwoPointersE4N392 {
    public boolean isSubseq(String s, String t) {
        int iSubseq = 0;
        int iOriseq = 0;
        while(iOriseq < t.length() && iSubseq < s.length()) {
            if(s.charAt(iSubseq) == t.charAt(iOriseq)) {
                iSubseq++;
                iOriseq++;
            } else {
                iOriseq++;
            }
        }
        return iSubseq == s.length();
    }
}
