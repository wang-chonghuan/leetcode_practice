package Greedy;

import java.util.Arrays;

/**
 * Maximum Units on a Truck
 *
 * You are assigned to put some amount of boxes onto one truck.
 * You are given a 2D array boxTypes,
 * where boxTypes[i] = [numberOfBoxes-i, numberOfUnitsPerBox-i]:
 *
 * numberOfBoxes-i is the number of boxes of type i.
 * numberOfUnitsPerBox-i is the number of units in each box of the type i.
 * You are also given an integer truckSize,
 * which is the maximum number of boxes that can be put on the truck.
 * You can choose any boxes to put on the truck
 * as long as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 *
 * 题意：m种盒子，每种盒子有n个，每种盒子能装k个单位，卡车能装truckSize个盒子
 * 问怎么选择盒子装的最多
 *
 * 很简单，用贪婪算法，先取能装最多单位的盒子，取完取次之的，需要排序
 * 所以要对boxTypes排序，问题是怎么对二维数组排序
 */
public class GreedyP2N1710 {
    public int findMaxUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int iBox = 0;
        int cntUnits = 0;
        while(truckSize > 0 && iBox < boxTypes.length) {
            int numBox = boxTypes[iBox][0];
            int numUnit = boxTypes[iBox][1];
            if(truckSize >= numBox) {
                cntUnits += numUnit * numBox;
                truckSize -= numBox;
                iBox++;
            } else {
                cntUnits += numUnit * truckSize;
                truckSize -= truckSize;
            }
        }
        return cntUnits;
    }
}
