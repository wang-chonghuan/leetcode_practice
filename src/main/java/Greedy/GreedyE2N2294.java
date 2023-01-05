package Greedy;

import java.util.Arrays;

/**
 * Example 2: 2294. Partition Array Such That Maximum Difference Is K
 *
 * Given an integer array nums and an integer k,
 * split nums into subsequences,
 * where each subsequences' maximum and minimum element is within k of each other. What is the minimum number of subsequences needed?
 *
 * For example, given nums = [3,6,1,2,5] and k = 2, the answer is 2.
 * The subsequences are [3, 1, 2] and [6, 5].
 *
 * 首先明确题意，把一个数组分成m个子序列，每个序列的最大元素和最小元素的差值小于等于k
 * 如何让m最小？
 * 子序列，不是子数列，子序列是从原数列中删除一些元素得到的，不做任何其他操作
 * 子数列是连续的，子序列不用连续，但要保持原来顺序
 *
 * 取法是，针对每一个元素，如果它是子序列的最小元素，那么它应该把所有能包含的元素都包含进来
 * 解释如下：
 * 假设我取一个子序列A， 其最小元素是1，那么最大元素必须是1+2=3（因为k=2）
 * ，不能再大，否则差值会超过k
 * 因此针对最小元素是1的子序列，其最大元素必须是3
 * ，那么该子序列是否要包括2呢？
 * 必须包括。因为如果不包括，那么如果2是子序列B的最大元素，子序列B的最小元素就应该是0了
 * 原始数组中没有0，因此这个2无处安放
 * 总结：从最小的元素1开始构建子序列，必须保证该子序列最长（所以是1到3）
 * ，同时该子序列包含的元素最多（所以必须包括2）
 *
 * 再次梳理思路：
 * 我想让m最小，我就要让每个子序列尽可能的长
 * 假设我针对一个元素x来构建子序列A，如何让它尽可能长？
 * 我可以让该子序列A的最小值是x，最大值是x+k，最大值不能再大，否则不满足差不大于k
 * x到x+k中的所有元素必须包含在序列A中
 * 假设x+k-1不包含在序列A中而在序列B中，那么x-1必须包含在B中。
 * 如果x是数组的最小值？就不存在x-1，那么x+k-1所在的B就不可能是最长的。
 * 所以我们发现，虽然题目中要求的是subseq，但实际上我们并没有考虑subseq中的顺序
 * ，而是只考虑了其中的最大最小值，因此可以看作subset。
 * 所以把arr排序，从小到大，从小开始贪婪的构建子序列
 *
 * 另一个难点是，计数要从1开始
 * 这样理解，如果不是从1开始计数，其实少了1个
 * ，因为第一次切，切出来的是2个序列， 第二次切，切出来的是3个序列
 */
public class GreedyE2N2294 {
    public int minNumSubseq(int[] nums, int k) {
        Arrays.sort(nums);
        int numSubseq = 1;
        int subseqLeft = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - nums[subseqLeft] > k) {
                subseqLeft = i;
                numSubseq++;
            }
        }
        return numSubseq;
    }
}


