package Tree;

/**
 * 98. Validate Binary Search Tree
 *
 * Given the root of a binary tree,
 * determine if it is a valid BST.
 *
 * 默认bst中没有重复元素,如果有,题目一般会特别说明,参考501
 * 每个子树的所有节点值都在一个区间里
 * 比如n的左子树,其所有值的区间是(-inf,n.v)
 * n的右子树,其所有值的区间是(n.v,+inf)
 * 如果某子树违反了该区间,就不是有效bst
 *
 * 有两个坑, 第一是[2,2,2]不是bst,所以如果节点值等于边界,要返回错误
 * 其次要用long,不知道为什么
 */
public class BstE3N98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode node, long small, long large) {
        if(node == null) {
            return true;
        }
        if(node.val >= large || node.val <= small) {
            return false;
        }
        boolean left = dfs(node.left, small, node.val);
        boolean right = dfs(node.right, node.val, large);
        return left && right;
    }
}
