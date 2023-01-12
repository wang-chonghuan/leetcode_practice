package Tree;

/**
 * 1448. Count Good Nodes in Binary Tree
 *
 * Given the root of a binary tree, find the number of nodes that are good.
 * A node is good if the path between the root and the node has no nodes with a greater value.
 *
 * 关键是思考每次迭代的中间变量,我认为本题是最大值
 * 本题有两个变量,一是节点个数,二是当前最大值
 */
public class BitreeDFSE3N1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        // 递归的终止条件
        if(node == null) {
            return 0;
        }
        int cntForCurNode = 0;
        // 先判断本节点是否是好节点
        if(node.val >= max) {
            cntForCurNode++;
        }
        // 再判断左右子树是否是好节点(递归关系)
        int cntLeft = dfs(node.left, Math.max(max, node.val));
        int cntRight = dfs(node.right, Math.max(max, node.val));
        cntForCurNode += cntLeft + cntRight;
        // 返回好节点
        return cntForCurNode;
    }
}
