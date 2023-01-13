package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 2: 530. Minimum Absolute Difference in BST
 *
 * Given the root of a BST,
 * return the minimum absolute difference
 * between the values of any two different nodes in the tree.
 *
 * insight: 最小值必是两个相邻元素的差值,所以排序是好的
 */
public class BstE2N530 {
    public int getMinimumDifference(TreeNode root) {
        var l = getSortedVal(root);
        int minDiff = Integer.MAX_VALUE;
        if(l.size() <= 2) {
            return minDiff;
        }
        for(int i = 1; i < l.size(); i++) {
            minDiff = Math.min(minDiff,
                    Math.abs(l.get(i) - l.get(i - 1)));
        }
        return minDiff;
    }

    private List<Integer> getSortedVal(TreeNode node) {
        if(node == null) {
            return new ArrayList<>();
        }
        var leftList = getSortedVal(node.left);
        var rightList = getSortedVal(node.right);
        leftList.add(node.val);
        leftList.addAll(rightList);
        return leftList;
    }
}
