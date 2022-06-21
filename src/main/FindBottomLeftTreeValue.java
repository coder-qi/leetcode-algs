import util.TreeNode;

/**
 * 513. 找树左下角的值：https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {

    int ans, level;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > this.level) {
            this.level = level;
            ans = root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {

    }

}
