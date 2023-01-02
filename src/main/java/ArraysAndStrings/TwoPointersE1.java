package ArraysAndStrings;

/**
 * Example 1: Return true if a given string is a palindrome, false otherwise.
 *
 * 两个指针，左指针指头，右指针指尾，比较其字符是否相等，不相等马上返回错
 * 相等的话，让两个指针靠近，继续比较，直到两指针相遇
 */
public class TwoPointersE1 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
