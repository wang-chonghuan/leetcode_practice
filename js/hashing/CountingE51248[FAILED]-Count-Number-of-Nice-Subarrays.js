/**
 * @param {number[]} nums 
 * @param {number} k
 * @return {number}
 * Given an array of positive integers nums and an integer k. Find the number of subarrays with exactly k odd numbers in them.
 * 找到恰好有k个奇数数字的子序列的个数 
 */
var numberOfSubarrays = function (nums, k) {
  let counts = new Map();
  counts.set(0, 1); // 有0个奇数数字的子序列个数为1
  let ans = 0, curr = 0;
  
  for (const num of nums) {
      // 当前数字如果是奇数，奇数计数加1。前序和
      curr += num % 2;
      // 如果curr-k存在，说明截止到当前num，出现了一个k个奇数的子序列
      ans += counts.get(curr - k) || 0;
      counts.set(curr, (counts.get(curr) || 0) + 1);
  }

  return ans;
}
