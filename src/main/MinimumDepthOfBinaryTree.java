/**
 * 二叉树的最小深度：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLeftDepth = minDepth(root.left);
        int minRightDepth = minDepth(root.right);
        if (minLeftDepth == 0 || minRightDepth == 0) {
            return minLeftDepth + minRightDepth + 1;
        }
        return Math.min(minLeftDepth, minRightDepth) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minDepth(TreeNode.of(3,9,20,null,null,15,7))); // 2
        System.out.println(minDepth(TreeNode.of(2,null,3,null,4,null,5,null,6))); // 5
        System.out.println(minDepth(TreeNode.of(-9,-3,2,null,4,4,0,-6,null,-5))); // 3
    }

}
