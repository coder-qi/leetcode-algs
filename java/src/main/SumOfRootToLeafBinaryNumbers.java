import util.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和：https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumOfRootToLeafBinaryNumbers {

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        if (root.right == null && root.left == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }

    public static void main(String[] args) {
        System.out.println(sumRootToLeaf(TreeNode.of(1,0,1,0,1,0,1)));
    }

}
