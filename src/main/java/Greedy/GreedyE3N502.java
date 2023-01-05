package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Example 3: 502. IPO
 *
 * LeetCode would like to work on some projects to increase its capital before IPO.
 * You are given n projects where the i-th project has a profit of profits[i]
 * and a minimum capital of capital[i] is needed to start it.
 * Initially, you have w capital.
 *
 * When you finish a project, the profit will be added to your total capital.
 * Return the max capital possible if you are allowed to do up to k projects.
 *
 * 先分析题意。你有w的资本，有n个项目，每个项目都有资本和利润，分别在两个数组里。
 * 想完成一个项目，首先你的资本要大于它，然后完成之后，它的利润会加入你的资本。
 * 你的资本不会减少，资本不是成本，这是关键点。
 * 每次都应该选择在能承受的资本范围内的最有利润的项目！【贪婪】
 * 所以我把项目利润从大到小排序，按利润从大到小遍历项目，直到能承受资本，就做这个项目
 * 做完一个项目，我的资本增加了，我再按利润从大到小遍历项目，循环
 *
 * 但是先遍历利润，再选资本，效率不高
 * 不如先把资本从小到大排序，把所有小于当前w的项目（根据利润）都放入最大堆中，
 * 每次从最大堆中取出的，就是能承担的资本中的利润最大的项目
 *
 * 一个坑：如果堆空了，说明项目已经取完，不能再承担新项目了，直接返回w
 * 小于等于w
 */
public class GreedyE3N502 {
    public int findMaxCapital(int[] profits, int[] capital, int w, int k) {
        // 合并两个数组到项目数组
        int numProjects = profits.length;
        int[][] projects = new int[numProjects][2];
        for(int i = 0; i < numProjects; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }
        // 根据资本从小到大排序这些项目
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        // 建立最大堆，用来找到能承受资本中的最大利润
        var maxProfitHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        // 遍历所有项目的指针
        int iProject = 0;
        // 用循环依次选出k个项目
        for(int projTaken = 0; projTaken < k; projTaken++) {
            // 把能承受资本的所有项目的利润放入堆中
            while(iProject < numProjects && projects[iProject][0] <= w) {
                maxProfitHeap.add(projects[iProject][1]);
                iProject++;
            }
            // 如果堆空了，说明项目已经取完，不能再承担新项目了，直接返回w
            if(maxProfitHeap.isEmpty()) {
                return w;
            }
            // 堆顶就是最大利润，加入资本
            w += maxProfitHeap.remove();
        }
        return w;
    }
}
