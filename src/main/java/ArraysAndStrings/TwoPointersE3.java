package ArraysAndStrings;

/**
 * Example 3: Given two sorted integer arrays,
 * return an array that combines both of them and is also sorted.
 *
 * 用两个指针分别指向两个数组，比较其值，把小的值放进新数组，同时移动小的指针，大的指针不动
 * 最后大概率有一个数组还有剩余，把它继续追加进结果数组即可
 */
public class TwoPointersE3 {
    public int[] mergeSortedArr(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1 < arr1.length && i2 < arr2.length) {
            if(arr1[i1] <= arr2[i2]) {
                mergedArr[i] = arr1[i1];
                i1++;
            } else {
                mergedArr[i] = arr2[i2];
                i2++;
            }
            i++;
        }
        while(i1 < arr1.length) {
            mergedArr[i] = arr1[i1];
            i++;
        }
        while(i2 < arr2.length) {
            mergedArr[i] = arr2[i2];
            i++;
        }
        return mergedArr;
    }
}
