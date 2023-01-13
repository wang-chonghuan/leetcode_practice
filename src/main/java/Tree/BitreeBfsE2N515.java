package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 *
 * Given the root of a binary tree,
 * return an array of the largest value in each row of the tree.
 */
public class BitreeBfsE2N515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        // 必不可少
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while(!levelNodes.isEmpty()) {
            int levelCnt = levelNodes.size();
            int levelMax = Integer.MIN_VALUE;
            for(int i = 0; i < levelCnt; i++) {
                var curNode = levelNodes.remove();
                if(curNode == null) {
                    continue;
                }
                levelMax = Math.max(levelMax, curNode.val);
                if(curNode.left != null) {
                    levelNodes.add(curNode.left);
                }
                if(curNode.right != null) {
                    levelNodes.add(curNode.right);
                }
            }
            ret.add(levelMax);
        }
        return ret;
    }
}
