"""
189. Rotate Array
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
题解：
给一个整数数组，右移位k步，k是非负数
思路：
数组长度是n, k等于n时，保持原样，k大于n时，取模。k小于n时，才值得思考。我的思路是，只分析k小于n时。先把原数组的第0个，仿佛k区间的第0个。然后把最后k区间的第0个，放入原数组的第0个。以此类推。
"""
class Solution:
    def rotate(self, nums: list[int], k: int) -> None:
        n = len(nums)
        k %= n
        start_idx = 0
        count = 0
        while count < n:
            current_idx, prev_val = start_idx, nums[current_idx]
            while True:
                next_idx = (current + k) % n
                nums[next_idx], prev = prev, nums[next_idx]