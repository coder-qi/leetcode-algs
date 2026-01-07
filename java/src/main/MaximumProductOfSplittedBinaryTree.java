import util.TreeNode;

/**
 * 1339. 分裂二叉树的最大乘积：https://leetcode.cn/problems/maximum-product-of-splitted-binary-tree
 */
public class MaximumProductOfSplittedBinaryTree {

    int sum;
    long ans = 0;

    public int maxProduct(TreeNode root) {
        int mod = 1000000007;
        sum = sum(root);
        dfs(root);
        return (int) (ans % mod);
    }

    private int sum(TreeNode x) {
        if (x == null) {
            return 0;
        }
        return sum(x.left) + sum(x.right) + x.val;
    }

    private int dfs(TreeNode x) {
        if (x == null) {
            return 0;
        }
        int s = dfs(x.left) + dfs(x.right) + x.val;
        ans = Math.max(ans, (long) s * (sum - s));
        return s;
    }

}
