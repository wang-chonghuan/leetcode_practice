package Tree;

/**
 * You are given the root node of a binary search tree (BST)
 * and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion,
 * as long as the tree remains a BST after insertion. You can return any of them.
 *
 * 试着理解一下最简的算法
 * 如果该节点是空的, 就创造一个节点
 * 如果值比该节点大, 就插入右边, 父是右子树的根
 * 如果值比该节点小, 就插入左边, 父是左子树的根
 * 关键在于, 其返回值, 刚好作为其父节点的子节点
 *
 * 只处理只有0个和1个节点的最简单的情况
 * 如果原树只有0个节点,那么只用new出来一个,就是根
 * 如果原树有1个节点,那么只用想查右边还是插左边就行了,不用想继续怎么递归
 */
public class BstP1N701 {

    public TreeNode insertIntoBST_STD(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val, null, null);
        }
        if(val > root.val) {
            root.right = insertIntoBST_STD(root.right, val);
        } else if(val < root.val) {
            root.left = insertIntoBST_STD(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val, null, null);
        }
        if(val > root.val) {
            insert(root.right, val, root);
        }
        if(val < root.val) {
            insert(root.left, val, root);
        }
        return root;
    }
    public void insert(TreeNode root, int val, TreeNode parent) {
        if(root == null && parent != null) {
            if(val > parent.val) {
                parent.right = new TreeNode(val, null, null);
            } else if(val < parent.val) {
                parent.left = new TreeNode(val, null, null);
            }
            return;
        }
        if(root.val > val) {
            insert(root.left, val, root);
        }
        if(root.val < val) {
            insert(root.right, val, root);
        }
    }
}
