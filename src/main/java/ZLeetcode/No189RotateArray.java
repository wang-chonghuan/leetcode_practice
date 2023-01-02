package ZLeetcode;

public class No189RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int finalRotate = k % len;
        System.out.println(finalRotate);
        int[] newNums = new int[len];
        System.arraycopy(nums, len - finalRotate - 1, newNums, 0, finalRotate);
        System.arraycopy(nums, 0, newNums, finalRotate, len - finalRotate);
        System.arraycopy(newNums, 0, nums, 0, len);
    }

    public void mod(int len, int k) {
        System.out.println(k % len);
    }
}
