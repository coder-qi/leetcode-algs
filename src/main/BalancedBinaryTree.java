/**
 * 平衡二叉树：https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out
            .println(new BalancedBinaryTree().isBalanced(TreeNode.of(3, 9, 20, null, null, 15, 7)));
        System.out.println(
            new BalancedBinaryTree().isBalanced(TreeNode.of(1, 2, 2, 3, 3, null, null, 4, 4)));
    }

}
