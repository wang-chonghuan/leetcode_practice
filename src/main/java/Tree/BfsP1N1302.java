package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. Deepest Leaves Sum
 * Given the root of a binary tree,
 * return the sum of values of its deepest leaves.
 */
public class BfsP1N1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while(!levelNodes.isEmpty()) {
            int levelCnt = levelNodes.size();
            boolean levelHasSubtree = false;
            int levelSum = 0;
            for(int i = 0; i < levelCnt; i++) {
                var curNode = levelNodes.remove();
                if (curNode == null) {
                    continue;
                }
                levelSum += curNode.val;
                if (curNode.left != null) {
                    levelHasSubtree = true;
                    levelNodes.add(curNode.left);
                }
                if (curNode.right != null) {
                    levelHasSubtree = true;
                    levelNodes.add(curNode.right);
                }
            }
            if(!levelHasSubtree) {
                return levelSum;
            }
        }
        return 0;
    }
}
