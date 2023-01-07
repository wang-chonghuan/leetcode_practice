package BinarySearch;

// 当数组从小到大排列时
public class Template {
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while(left <= right) {
            // 不可以用 mid=(left+right)/2，因为left+right可能会溢出int
            mid = left + (right - left) / 2;
            if(target < arr[mid]) {
                right = mid - 1; // right不可以用mid,因为left,right是闭区间
            } else if(target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        // 如果target不在arr里，那么left就是插入target的位置
        return left;
    }

    // 当有重复元素时,找到最左端的那个
    public int binarySearchLeftMost(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < arr[mid]) {
                right = mid - 1;
            } else if(target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1; // 找到了该值,假设它在最右端,就往左再找找看
            }
        }
        return left;
    }

    // 当有重复元素时,找到最右端的那个
    public int binarySearchRightMost(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target < arr[mid]) {
                right = mid - 1;
            } else if(target > arr[mid]) {
                left = mid + 1;
            } else {
                left = mid + 1; // 找到了该值,假设它在最左端,就往右再找找看
            }
        }
        return left;
    }
}
