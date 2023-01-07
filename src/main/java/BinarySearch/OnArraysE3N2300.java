package BinarySearch;

import java.util.Arrays;

/**
 * Example 3: 2300. Successful Pairs of Spells and Potions
 *
 * You are given two positive integer arrays spells and potions,
 * where spells[i] represents the strength of the i-th spell
 * and potions[j] represents the strength of the j-th potion.
 * You are also given an integer success.
 *
 * A spell and potion pair is considered successful
 * if the product of their strengths is at least success.
 * For each spell, find how many potions it can pair with to be successful.
 * Return an integer array where the i-th element is the answer for the i-th spell.
 *
 * 坑:出现整型乘积时,必须用long
 *
 * 方法,对potion做leftmost二分查找
 */
public class OnArraysE3N2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // 不需要排序spells
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int leftMostPos = binarySearchLeftmost(potions, spells[i], success);
            ans[i] = potions.length - leftMostPos;
        }

        return ans;
    }

    // 涉及到乘积,一定要把一个乘数强转成long
    public int binarySearchLeftmost(int[] potions, long spell, long success) {
        int left = 0;
        int right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(success < potions[mid] * spell){
                right = mid - 1;
            } else if (success > potions[mid] * spell) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 如果success很大,每次都是left=mid+1而right不变,最后left==right+1(不会成功)
        // 如果success很小,每次都是right=mid-1而left不变,最后left==0
        return left;
    }
}
