"""
26. Remove Duplicates from Sorted Array
题解：整数数组，升序，在数组中删除重复元素，元素的相对顺序不变，返回distinct元素个数。该原始数组的前k个元素就是去重后的k个元素。k之后的元素不考虑。
思路：指针i遍历，指针j指向要插入的位置，i和j都指向1，从1开始。
当i-1和i相等时，说明出现了一个重复元素，那么j不变，它指向的就是重复的元素。
当i-1和i不相等时，说明出现了一个新元素，那么j就要指向i后面的元素，新元素不能被覆盖。当i遍历完所有的元素后，结束。
"""
class Solution:
    def solve(self, nums: list[int]) -> int:
        n = len(nums)
        if n < 1:
            return 1
        i = 1; j = 1
        for i in range(1, n):
            if nums[i - 1] != nums[i]:
                nums[j] = nums[i]
                j = j + 1
        return j