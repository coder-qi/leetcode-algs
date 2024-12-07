import util.TreeNode;

/**
 * 二叉树的最大深度：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(TreeNode.of(3,9,20,null,null,15,7)));
    }

}
