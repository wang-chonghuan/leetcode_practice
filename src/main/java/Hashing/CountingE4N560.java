package Hashing;

import java.util.HashMap;

/**
 * Example 4: 560. Subarray Sum Equals K
 *
 * Given an integer array nums and an integer k,
 * find the number of subarrays whose sum is equal to k.
 *
 * 和等于k的子数组的个数
 * 如果两个前序的差等于k,那么这两个序数之间的子数组的和就等于k
 * 问题转化为,有哪些前序和的差等于k
 * 问题再转化为,对于一个前序和s,看看s-k是否存在
 *
 * 有一个坑,就是必须放入一个前序和为0的,因为整个数组也可能是符合条件的子序列
 * 另一个坑,如果输入是[1],0,输出应该是0,而不是1
 * 此时原始数组是[1],k是0,
 * 前序和数组是[1],map里是0-1, 1-1,
 * sum-k=1-0=1,其补数也在map里!
 * 也就是说,如果k=0,补数都会在map里,因为就是它自己
 *
 * [-1,-1,1] k=1
 * presums [-1,-2,-1]
 * map 0:1, -1:2, -2:1
 */
public class CountingE4N560 {
    public int subarraySum(int[] nums, int k) {
        // 计算前序和
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        // 前序和的频次map
        var prefixSumFrqMap = new HashMap<Long, Integer>();
        //prefixSumFrqMap.put(0L, 1); // 必须放入一个前序和为0的,因为整个数组也可能是符合条件的子序列
        for(var ps : prefixSum) {
            prefixSumFrqMap.put(ps,
                    prefixSumFrqMap.getOrDefault(ps, 0) + 1);
        }
        // 遍历前序和数组,寻找补数,总的补数数量即为答案
        int cnt = 0;
        for(long preSum : prefixSumFrqMap.keySet()) {
            long compSum = preSum - k;
            if(prefixSumFrqMap.containsKey(compSum)) { // 如果包含补数
                int compFrq = prefixSumFrqMap.get(compSum);
                System.out.println("n:" + preSum + " c:" + compSum + " f:" + compFrq);
                if(preSum == compSum) {
                    cnt += compFrq - 1;
                } else {
                    cnt += compFrq;
                }
            }
        }
        return cnt;
    }
}

