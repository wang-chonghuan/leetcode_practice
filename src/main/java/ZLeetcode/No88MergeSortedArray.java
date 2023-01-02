package ZLeetcode;

import java.util.Arrays;

public class No88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1copy = new int[m];
        System.arraycopy(nums1, 0, nums1copy, 0, m);
        int p1 = 0, p2 = 0, p = 0;
        while(p != m + n) {
            if(p2 >= n || (p1 < m && nums1copy[p1] <= nums2[p2])) {
                nums1[p] = nums1copy[p1];
                ++p1;
            } else { // if(p1 >= m || p2 < n && nums2[p2] <= nums1copy[p1]) 这两个条件是对称的, 假定p2剩的多即可
                nums1[p] = nums2[p2];
                ++p2;
            }
            ++p;
        }
    }
    public static void test() {
        No88MergeSortedArray c = new No88MergeSortedArray();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        c.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
