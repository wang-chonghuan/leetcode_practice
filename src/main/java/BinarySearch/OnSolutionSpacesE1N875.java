package BinarySearch;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 *
 * Koko loves to eat bananas. There are n piles of bananas,
 * the i-th pile has piles[i] bananas.
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses a pile and eats k bananas from that pile.
 * If the pile has less than k bananas,
 * she eats all of them and will not eat any more bananas during the hour.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * n堆香蕉piles数组,每小时选一堆吃k个香蕉,即使吃不到k也不能吃另一堆
 * 返回最小k使得她在h小时内能吃完所有的香蕉
 *
 * n堆香蕉,至少要吃n次,因为一次只能吃一堆,
 * 此时k应该大于等于最大堆的香蕉个数,这样能在n小时吃完,n小于等于h,这是必须的
 *
 * 如果k比最大堆香蕉个数大,那么一定能在n小时吃完
 * 如果k小,就不一定了,因为最大堆要分2次吃,如果k再小,次大堆也要分2次吃,以此类推
 *
 * 总之,吃的次数要小于等于h,h一定大于等于n
 * k越小,吃的次数越多
 *
 * 以上在做的思考,是挖掘题意中隐含的条件,对题意进行一些推理,推理出一些结论,
 * 让题意更明确,比如k最大是最大堆的香蕉个数,就是推导出来的
 * 有了新的条件,就能更好的寻找模板
 *
 * 建立一个解空间的数组,其元素代表不同的k的可能性,最小的k是0,最大的k是最大堆香蕉个数
 * 对这个解空间进行二分查找,不像以前一样,是找arr[mid]==tar,而是找该k是否能在h小时内吃完
 * 如何判断k能在h小时吃完,首先小于等于k的堆,一次就能吃完.大于k的堆,用k/pile向上取整
 * 丢失精度和截断是做lc题的大问题
 */
public class OnSolutionSpacesE1N875 {

    public int minEatingSpeed(int[] piles, int h) {
        int maxK = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        int right = maxK;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(hrsBySpeedK(piles, mid) < h) {
                right = mid - 1;
            } else if(hrsBySpeedK(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long hrsBySpeedK(int[] piles, int k) {
        long totalHrs = 0; // 累加时一定要用long
        for(var pile : piles) {
            totalHrs += (int)Math.ceil((double)pile / (double) k); // 弄反了
        }
        return totalHrs;
    }
}
