package BinarySearch;

/**
 * Example 2: 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * 运用数学技巧把矩阵当成一维数组处理,int row = mid / n; int col = mid % n;
 */
public class OnArraysE2N74 {
    public boolean searchSortedMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            if(target < matrix[row][col]) {
                right = mid - 1;
            } else if(target > matrix[row][col]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
