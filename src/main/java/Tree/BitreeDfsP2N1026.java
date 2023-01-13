package Tree;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 *
 * Given the root of a binary tree, find the maximum value v
 * for which there exist different nodes a and b
 * where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either:
 * any child of a is equal to b or any child of a is an ancestor of b.
 *
 * 其实思路还是针对每一个节点,与这条线上的所有节点作比较,求最大差值
 * 但是如果沿途记录了这条线上的最大值和最小值,就不用与每个节点比较,只比较最大值最小值即可
 */
public class BitreeDfsP2N1026 {
    public int maxAncestorDiff(TreeNode root) {
        // 处理边界情况
        if(root == null) {
            return 0;
        }
        return dfs(root, root.val, root.val, 0);
    }

    /**
     *
     * @param node 当前节点
     * @param maxLineVal 该条线上的节点的最大值
     * @param minLineVal 该条线上的节点的最小值
     * @param maxDiff 全局最大差值
     * @return 更新后的全局最大差值
     */
    private int dfs(TreeNode node, int maxLineVal, int minLineVal, int maxDiff) {
        if(node == null) {
            return maxDiff;
        }
        // 当前节点在该线上的最大差值
        int maxLineDiff = Math.max(
                Math.abs(node.val - maxLineVal),
                Math.abs(node.val - minLineVal));
        // 为了递归, 更新全局最大差值
        maxDiff = Math.max(maxDiff, maxLineDiff);
        // 为了递归, 更新当前线的最大值
        maxLineVal = Math.max(maxLineVal, node.val);
        minLineVal = Math.min(minLineVal, node.val);
        // 分别获得左右子树的最大差值
        int maxDiffLeft = dfs(node.left, maxLineVal, minLineVal, maxDiff);
        int maxDiffRight = dfs(node.right, maxLineVal, minLineVal, maxDiff);
        // 返回左右子树的最大差值
        return Math.max(maxDiffLeft, maxDiffRight);
    }
}