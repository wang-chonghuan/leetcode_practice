package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Example 4: 1481. Least Number of Unique Integers after K Removals
 *
 * Given an array of integers arr and an integer k,
 * find the least number of unique integers
 * after removing exactly k elements.
 *
 * 给一个数组，和k，你可以从数组中删除k个数字，但是要求，剩下的（数字去重后）尽可能少
 * 那么就是要求剩下的数字尽可能多重复
 * 把剩下的数字去重，最终越少越好，最少是多少？
 *
 * 贪婪问题的特征是，求最大最小，可以排序，可以用堆，这类问题就试着用贪婪算法
 *
 * 我最初的想法是，优先保留重复次数最多的数字，删除重复次数最少的数字
 * 看了答案后的思路是：
 * 先用哈希表来统计所有的数字的频次
 * 根据频次，从小到大，排序数字和频次的pair
 *
 * 依次删除频次最小的数字，同时扣减k，
 * 注意坑，某数字可能有多个，因此删除一个数字时，可能需要多次扣减K
 *
 * 此处还用了一个技巧，从链表的末尾删除频率最小的数字，这个链表是频率，从大到小排列
 * 删除最小的，剩下的长度就是答案
 *
 * 另一个坑是java技巧
 * 该列表不可修改，显然您的客户端方法正在创建一个不可修改的列表
 * （使用例如Collections#unmodifiableList等）。
 * 在排序之前简单地创建一个可修改的列表：
 * List<String> modifiableList = new ArrayList<String>(unmodifiableList);
 * Collections.sort(modifiableList, comparator);
 *
 */
public class GreedyE4N1481 {
    public int findMinCntUniqueNum(int[] arr, int k) {
        var numFreqMap = new HashMap<Integer, Integer>();
        for(int num : arr) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }
        //var sortedFreq = numFreqMap.values().stream().toList();
        //sortedFreq.sort(Comparator.reverseOrder());
        //Collections.sort(sortedFreq, Comparator.reverseOrder());
        var sortedFreq = new ArrayList<Integer>(numFreqMap.values().stream().toList());
        sortedFreq.sort(Comparator.reverseOrder());
        while(k > 0) {
            int curFreq = sortedFreq.get(sortedFreq.size() - 1);
            if(k >= curFreq) {
                k -= curFreq;
                sortedFreq.remove(sortedFreq.size() - 1);
            } else {
                k = 0;
            }
        }
        return sortedFreq.size();
    }
}
