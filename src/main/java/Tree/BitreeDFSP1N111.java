package Tree;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 *
 * 只在有子树的一侧调用递归, 不要不管是不是null就直接调用
 *
 *
 */
public class BitreeDFSP1N111 {
    public int minDepth(TreeNode root) {
        return dps(root, 0);
    }

    public int dps(TreeNode node, int curNodeDep) {
        if(node == null) {
            return curNodeDep;
        }
        // 如果是叶节点
        if(node.left == null && node.right == null) {
            return curNodeDep + 1;
        }
        // 如果不是叶节点
        int leftMinDepth = Integer.MAX_VALUE, rightMinDepth = Integer.MAX_VALUE;
        if(node.left != null) {
            leftMinDepth = dps(node.left, curNodeDep + 1);
        }
        if(node.right != null) {
            rightMinDepth = dps(node.right, curNodeDep + 1);
        }
        return Math.min(leftMinDepth, rightMinDepth);
    }

    public int minDepthSTD(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 叶子
        if(root.left == null && root.right == null) {
            return 1;
        }
        // 子树
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null) {
            minDepth = Math.min(minDepthSTD(root.left), minDepth);
        }
        if(root.right != null) {
            minDepth = Math.min(minDepthSTD(root.right), minDepth);
        }
        return minDepth + 1; // 这句最关键,每次迭代,深度增加一!!!
    }
}
