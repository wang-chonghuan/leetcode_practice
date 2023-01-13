package Tree;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given the root of a binary tree and two nodes p and q that are in the tree,
 * return the lowest common ancestor (LCA) of the two nodes.
 * The LCA is the lowest node in the tree that has both p and q as descendants
 * (note: a node is a descendant of itself).
 *
 * we want our recursive function to return the answer to the question
 *
 * Therefore, calling on a subtree returns a non-null value
 * only if one of p or q is in that subtree.
 * Then, the second case is implied if both calls to the left and right subtrees return something,
 * and the third case is implied if only one of the calls returns something.
 *
 * 三种情况,
 * 第一种情况,p或q本身就是当前节点,
 *      那么当前节点就是最低父节点
 * 第二种情况,p和q分别在当前节点的两个子树上
 *      那么当前节点就是最低父节点
 * 第三种情况,p和q同在当前节点的一个子树上
 *      对这个子树继续递归
 *
 *
 */
public class BitreeDfsE4N236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        // 第一种情况,p或q本身就是当前节点,
        // 那么当前节点就是最低父节点
        if(root == p || root == q) {
            return root;
        }
        // 递归
        var ancestorLeft = lowestCommonAncestor(root.left, p, q);
        var ancestorRight = lowestCommonAncestor(root.right, p, q);
        // 第二种情况,p和q分别在当前节点的两个子树上(如何判断?)
        // 那么当前节点就是最低父节点
        if(ancestorLeft != null && ancestorRight != null) {
            return root;
        }
        // 第三种情况,p和q同在当前节点的一个子树上
        // 对这个子树继续递归
        if(ancestorLeft != null && ancestorRight == null) {
            return ancestorLeft;
        }
        if(ancestorLeft == null && ancestorRight != null) {
            return ancestorRight;
        }
        return null;
    }
}
