package Tree;

/**
 *  938. Range Sum of BST
 *
 * Given the root node of a binary search tree
 * and two integers low and high,
 * return the sum of values of all nodes
 * with a value in the inclusive range [low, high].
 *
 */
public class BstE1N938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(low <= root.val && root.val <= high) {
            sum += root.val;
        }
        if(root.val < low) {
            sum += rangeSumBST(root.right, low, high);
        } else if(root.val > high) {
            sum += rangeSumBST(root.left, low, high);
        } else {
            sum += rangeSumBST(root.right, low, high);
            sum += rangeSumBST(root.left, low, high);
        }
        return sum;
    }
}
