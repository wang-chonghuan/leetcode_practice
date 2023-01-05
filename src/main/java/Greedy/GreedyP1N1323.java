package Greedy;

import java.util.Arrays;

/**
 * 1323. Maximum 69 Number
 * You are given a positive integer num consisting only of digits 6 and 9.
 * Return the maximum number you can get
 * by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 * 用贪婪算法，只翻最高位的6
 * 难点在于把整数转成数组
 * 答案是用StringBuilder，更方便
 * 注意数组转成整数时，要用Math.pow
 */
public class GreedyP1N1323 {
    public int findMaxNum(int num) {
        int N = 4;
        int[] digiArr = new int[N];
        int left = num;
        // 个位数放在0
        for(int i = 0; left > 0; i++) {
            digiArr[i] = left % 10;
            left /= 10;
        }
        // 从最高位开始翻
        for(int j = N - 1; j >= 0; j--) {
            if(digiArr[j] == 6) {
                digiArr[j] = 9;
                break;
            }
        }
        int res = 0;
        for(int k = 0; k < N; k++) {
            res += digiArr[k] * (int)Math.pow(10, k);
        }
        return res;
    }

    public int maximum69Number (int num) {
        // Convert the input 'num' to a string builder 'numSB'.
        StringBuilder numSB = new StringBuilder();
        numSB.append(num);

        // Iterate over the string builer (from high to low).
        for (int i = 0; i < numSB.length(); ++i) {
            // If we find the first '6', replace it with '9' and break the loop.
            if (numSB.charAt(i) == '6') {
                numSB.setCharAt(i, '9');
                break;
            }
        }

        // Convert the modified string builder to integer and return it.
        return Integer.parseInt(numSB.toString());
    }
}
