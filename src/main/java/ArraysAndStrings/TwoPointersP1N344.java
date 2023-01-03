package ArraysAndStrings;

/**
 * Write a function that reverses a string.
 * The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * while的判断用小于，不要用!=，否则会越界！！！
 */
public class TwoPointersP1N344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while(left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
