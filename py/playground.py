def k_radius_average(nums, k):
    if k == 0:
        return nums

    n = len(nums)
    avgs = [-1] * n

    if 2 * k + 1 > n:
        return avgs

    prefix = [0] * (n + 1)
    for i in range(n):
        prefix[i + 1] = prefix[i] + nums[i]

    for i in range(k, n - k):
        avgs[i] = (prefix[i + k + 1] - prefix[i - k]) // (2 * k + 1)

    return avgs
