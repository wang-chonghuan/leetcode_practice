package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree and a target value,
 * return the value in the BST that is closest to the target.
 */
public class BstP2N270__ {
    public int closestValue(TreeNode root, double target) {
        var l = dfs(root);
        double minDiff = Math.abs((double)l.get(0) - target);
        int curVal = l.get(0);
        for(int i = 1; i < l.size(); i++) {
            double curDiff = Math.abs(( double)l.get(i) - target);
            if(curDiff < minDiff) {
                curVal = l.get(i);
                minDiff = curDiff;
            }
        }
        return curVal;
    }

    private List<Integer> dfs(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        var lLeft = dfs(root.left);
        var lRight = dfs(root.right);
        lLeft.add(root.val);
        lLeft.addAll(lRight);
        return lLeft;
    }
}
