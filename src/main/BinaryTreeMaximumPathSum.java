import util.TreeNode;

/**
 * 二叉树中的最大路径和：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       dfs(root);
       return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int s = Math.max(Math.max(root.val + leftSum, root.val + rightSum), root.val);
        maxSum = Math.max(maxSum, Math.max(leftSum + root.val + rightSum, s));
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(TreeNode.of(-10,9,20,null,null,15,7))); // 42
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(TreeNode.of(1,2,3))); // 6
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(TreeNode.of(-3))); // -3
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(TreeNode.of(2,-1,-2))); // 2
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(TreeNode.of(-1,null,9,-6,3,null,null,null,-2))); // 12
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(TreeNode.of(9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6))); // 16
    }

}
