package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order.
 *
 * 这题是从一组有重复的字符串里，找到频次最高的一些，放入数组返回，如果两个字符串频次一样，按ascii优先级排列
 * 方法是用最小堆，最小堆在维持k个元素时，可以把所有小的都弹出，剩下的就是前k个大的了
 * 技巧点有，一是如何排序，最好在heap声明时用lambda写好
 */
public class TopKP1N692 {
    public List<String> findMostFreqStrings(String[] words, int k) {
        var strFreqMap = new HashMap<String, Integer>();
        for(var word : words) {
            strFreqMap.put(word, strFreqMap.getOrDefault(word, 0) + 1);
        }
        var minHeap = new PriorityQueue<String>(
                (a, b) -> {
                    if(strFreqMap.get(a) != strFreqMap.get(b)) {
                        return strFreqMap.get(a) - strFreqMap.get(b);
                    } else {
                        return b.compareTo(a); // b.charAt(0) - a.charAt(0)
                    }
                });
        // 此处不能再用words往堆里放，因为有重复单词，而应该用map的keyset
        for(var word : strFreqMap.keySet()) {
            minHeap.add(word);
        }
        while(minHeap.size() > k) {
            minHeap.remove();
        }
        String[] mostFreqK = new String[k];
        for(int i = k - 1; i >= 0; i--) {
            mostFreqK[i] = minHeap.remove();
        }
        return Arrays.stream(mostFreqK).toList();
    }
}
