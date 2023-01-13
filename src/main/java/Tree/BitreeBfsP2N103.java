package Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given the root of a binary tree,
 * return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right,
 * then right to left for the next level and alternate between).
 */
public class BitreeBfsP2N103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        boolean isLeftToRight = true;
        while(!levelNodes.isEmpty()) {
            int levelCnt = levelNodes.size();
            var curLevelList = new LinkedList<Integer>();
            for(int i = 0; i < levelCnt; i++) {
                var curNode = levelNodes.remove();
                if(curNode == null) {
                    continue;
                }
                curLevelList.add(curNode.val);
                if(curNode.left != null) {
                    levelNodes.add(curNode.left);
                }
                if(curNode.right != null) {
                    levelNodes.add(curNode.right);
                }
            }
            if(isLeftToRight) {
                ret.add(curLevelList);
            } else {
                Collections.reverse(curLevelList);
                ret.add(curLevelList);
            }
            isLeftToRight = !isLeftToRight;
        }
        return ret;
    }
}
