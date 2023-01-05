package Greedy;

import java.util.Arrays;

/**
 * Example 1: 2126. Destroying Asteroids
 *
 * You are given an integer array asteroids
 * and an integer mass representing the mass of a planet.
 * The planet will collide with the asteroids one by one
 * - you can choose the order.
 * If the mass of the planet is less than the mass of an asteroid,
 * the planet is destroyed.
 * Otherwise, the planet gains the mass of the asteroid.
 * Can you destroy all the asteroids?
 *
 * 这题是用贪婪算法，排序，先撞小的，再撞大的。
 * 难点在于，为什么贪婪算法是正确的。分类讨论证明：
 * 如果所有流星都比行星轻，那么无所谓顺序，从小到大撞可以
 * 如果所有流行都比行星重，那么一定要从小到大撞，
 *      因为任何时刻，撞小的最安全，想撞大的，最好先撞小的积累质量
 * 如果一部分重，一部分轻，那么先撞轻的部分，可以从小到大，再撞重的部分，必须从小到大
 * 综上所述，必须从小到大
 *
 * 一个坑是，curMass一定要是long，否则会溢出，通不过测试覆盖
 */
public class GreedyE1N2126 {
    public boolean isDestoryed(int[] asteroids, int mass) {
        Arrays.sort(asteroids); // 最好不要改变输入参数
        long curMass = mass;
        for(int aMess : asteroids) {
            if(curMass < aMess) {
                return false;
            } else {
                curMass += aMess;
            }
        }
        return true;
    }
}
