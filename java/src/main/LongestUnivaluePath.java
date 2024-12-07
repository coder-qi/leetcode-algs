import util.TreeNode;

/**
 * 687. 最长同值路径：https://leetcode.cn/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {

    int len;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return len;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lc = dfs(root.left), rc = dfs(root.right);
        int lc1 = 0, rc1 = 0;
        if (root.left != null && root.val == root.left.val) {
            lc1 = lc + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rc1 = rc + 1;
        }
        len = Math.max(len, lc1 + rc1);
        return Math.max(lc1, rc1);
    }

    public static void main(String[] args) {

    }

}
