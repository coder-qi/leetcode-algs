import util.TreeNode;

/**
 * 路径总和：https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum = targetSum - root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        System.out.println(hasPathSum(TreeNode.of(5,4,8,11,null,13,4,7,2,null,null,null,1), 22));
        System.out.println(hasPathSum(TreeNode.of(1,2,3), 5));
        System.out.println(hasPathSum(null, 0));
        System.out.println(hasPathSum(TreeNode.of(-2, null, -3), -5));
    }

}
