"""
122. Best Time to Buy and Sell Stock II
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

题解：整数数组prices，代表每天的价格。每天可以买或卖该股票，
最多只能持有一份，当天可以买入并卖出。找到最大利润。
思路：遍历所有价格的过程中，只要当天的价格比昨天的价格高，就说明昨天买今天卖就能赚钱，那么就把这个差值加入到总利润中。
"""
class SolutionStd:
    def solve(self, prices: list[int]) -> int:
        n = len(prices)
        if n <= 1:
            return 0
        maxProfit = 0
        for i in range(1, n):
            profit = prices[i] - prices[i - 1]
            if profit > 0:
                maxProfit += profit
        return maxProfit
            
