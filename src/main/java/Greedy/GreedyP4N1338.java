package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 1338. Reduce Array Size to The Half
 *
 * You are given an integer array arr.
 * You can choose a set of integers
 * and remove all the occurrences of these integers in the array.
 *
 * Return the minimum size of the set
 * so that at least half of the integers of the array are removed.
 *
 * 题意：有一个整数数组A，从中选一个整数集合S，可以从A中删除S中所有的出现的数字（重复的也删除）
 * 返回最小的集合，使得至少一半整数被删除
 *
 * 我的思路是，用贪婪算法，取频次最高的数，直到一半被取完
 */
public class GreedyP4N1338 {
    public int findMinSet(int[] arr) {
        var numFreqMap = new HashMap<Integer, Integer>();
        for(var num : arr) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }
        // 不需要对数字排序，只需要对频次排序！！！
        Integer[] numsSortedByFreq = Arrays.stream(numFreqMap.keySet().stream().mapToInt(i -> i).toArray())
                                    .boxed()
                                    .toArray(Integer[]::new);
        Arrays.sort(numsSortedByFreq, (Integer a, Integer b) -> {return numFreqMap.get(b) - numFreqMap.get(a);});
        // 以下是对频次排序
        Integer[] sortedFreq = Arrays.stream(numFreqMap.values().stream().mapToInt(i -> i).toArray())
                                .boxed()
                                .toArray(Integer[]::new);
        Arrays.sort(sortedFreq, Comparator.reverseOrder());
        int halfSize = arr.length % 2 == 0 ? arr.length / 2 : (arr.length + 1) / 2;
        int removedNums = 0;
        int setSize = 0;
        for(int i = 0; i < sortedFreq.length; i++) {
            removedNums += sortedFreq[i];
            setSize++;
            if(removedNums >= arr.length / 2) {
                break;
            }
        }
        return setSize;
    }
}
