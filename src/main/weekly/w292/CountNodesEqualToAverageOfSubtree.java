package weekly.w292;

import util.TreeNode;

/**
 * 6057. 统计值等于子树平均值的节点数：https://leetcode-cn.com/problems/count-nodes-equal-to-average-of-subtree/
 */
public class CountNodesEqualToAverageOfSubtree {

    int ans;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] leftVals = dfs(root.left);
        int[] rightVals = dfs(root.right);
        int[] rootVals = new int[] { leftVals[0] + rightVals[0] + 1,
            leftVals[1] + rightVals[1] + root.val};
        if (rootVals[1] / rootVals[0] == root.val) {
            ans++;
        }
        return rootVals;
    }

    public static void main(String[] args) {

    }



}
