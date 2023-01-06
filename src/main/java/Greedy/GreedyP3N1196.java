package Greedy;

import java.util.Arrays;

/**
 * How Many Apples Can You Put into the Basket
 *
 * You have some apples and a basket that can carry up to 5000 units of weight.
 *
 * Given an integer array weight where weight[i] is the weight of the ith apple,
 * return the maximum number of apples you can put in the basket.
 */
public class GreedyP3N1196 {
    public int findMaxNumApples(int[] weight) {
        Arrays.sort(weight);
        int total = 5000;
        int cnt = 0;
        for(int i = 0; i < weight.length; i++) {
            if(total - weight[i] < 0) {
                break;
            } else {
                cnt++;
                total -= weight[i];
            }
        }
        return cnt;
    }
}

