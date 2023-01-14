package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 *
 * Given the root of a binary tree,
 * imagine yourself standing on the right side of it.
 * Return the values of the nodes you can see ordered from top to bottom.
 *
 * 就是打印一棵树最右侧的节点
 */
public class BfsE1N199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while(!levelNodes.isEmpty()) {
            int levelCnt = levelNodes.size();
            for(int i = 0; i < levelCnt; i++) {
                TreeNode curNode = levelNodes.remove();
                if(curNode == null) {
                    continue;
                }
                if(i == levelCnt - 1) {
                    ret.add(curNode.val);
                }
                if(curNode.left != null) {
                    levelNodes.add(curNode.left);
                }
                if(curNode.right != null) {
                    levelNodes.add(curNode.right);
                }
            }
        }
        return ret;
    }
}
