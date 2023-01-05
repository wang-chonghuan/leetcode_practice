package Greedy;

import java.util.Arrays;

/**
 * Example 5: 881. Boats to Save People
 *
 * You are given an array people where people[i] is the weight of the i-th person.
 * A boat can hold up to two people,
 * if their weight combined is less than or equal to limit.
 * What is the fewest number of boats you need to carry everyone?
 * Note: no person is heavier than limit.
 *
 * 答案和我的思路类似，先根据体重排序，从小到大
 * 用双指针的方法，一个小，一个大
 * 如果体重和刚好满足，就运走
 * 如果体重和超了，就小不动，大移动一格
 *
 * 如果体重没超，有没有必要大不动，小动一格？
 *
 * 方法简单，但是很难证明是最优的！
 * 试着证明：最大的危险最重的人，应该避免让他们单独坐船，所以他们最好搭配一个人。
 * 搭配最轻的人肯定是可以的。因为搭配最轻的人还不行，最重的肯定要单独坐船走。
 * 但是最重的搭配次轻的人呢？如果最重的搭配次轻的，次重的搭配次次轻的，
 * 其实最轻的人浪费了，因为他最优的效率就是和最重的人搭配
 *
 * 坑在于while(iLight <= iHeavy)
 * 轻的人和重的人是同一个人，不符合逻辑，所以最好最后单独处理if(iLight == iHeavy)
 * 就是说还剩一个人时，再运一次
 */
public class GreedyE5N881 {
    public int findMinBoats(int[] people, int limit) {
        Arrays.sort(people);
        int iLight = 0;
        int iHeavy = people.length - 1;
        int cntBoats = 0;
        while(iLight < iHeavy) {
            if(people[iLight] + people[iHeavy] <= limit) {
                iLight++;
                iHeavy--;
            } else {
                iHeavy--;
            }
            cntBoats++;
        }
        if(iLight == iHeavy) {
            cntBoats++;
        }
        return cntBoats;
    }
}
