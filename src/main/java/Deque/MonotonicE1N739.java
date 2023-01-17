package Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Example 1: 739. Daily Temperatures
 *
 * Given an array of integers temperatures that represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait
 * after the i day to get a warmer temperature.
 * If there is no future day that is warmer, have answer[i] = 0 instead.
 *
 * 题意解析:
 * 给一个数组temperatures代表每日温度
 * 返回一个数组answer,其每个元素a[i]代表第i天之后你要等几天才能遇到比a[i]更高的温度
 * 如果遇不到,a[i]=0
 *
 * 思路:把还没有找到结果的元素的下标全部放进栈里面
 * 把已经找到了结果的元素的下标马上弹出去
 * 结果就是下标的差值
 */
public class MonotonicE1N739 {
    int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Deque<Integer> maxStack = new LinkedList<>();
        for(int iTmp = 0; iTmp < temperatures.length; iTmp++) {
            // 如果当前遇到的温度,比栈顶的温度高,说明栈顶的温度找到了更高温
            // 但是栈顶下面的元素不一定遇到的是最高温,所以弹出后,继续判断
            // 栈顶下面的元素的温度一定比栈顶大,否则栈顶就是栈底遇到的最高温
            // 所以这个栈是单减栈(大的在最下面)压入元素时要维持顺序,弹出违反顺序的元素,而不是插入
            // 在栈里面的下标,都是还没找到结果的
            int curTmp = temperatures[iTmp];
            while(maxStack.size() > 0 && curTmp > temperatures[maxStack.getFirst()]) {
                int iFound = maxStack.removeFirst();
                ret[iFound] = iTmp - iFound;
            }
            maxStack.addFirst(iTmp);
        }
        return ret;
    }
}
