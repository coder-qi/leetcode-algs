import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 1161. 最大层内元素和：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 */
public class MaximumLevelSumOfABinaryTree {

    public static void main(String[] args) {

    }

    public static int maxLevelSum(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        dfs(root, 1, levelSums);
        int ansLevel = 1, maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= levelSums.size(); i++) {
            if (levelSums.get(i - 1) > maxSum) {
                ansLevel = i;
                maxSum = levelSums.get(i - 1);
            }
        }
        return ansLevel;
    }

    private static void dfs(TreeNode root, int level, List<Integer> levelSums) {
        if (root == null) {
            return;
        }
        if (level > levelSums.size()) {
            levelSums.add(0);
        }
        levelSums.set(level - 1, levelSums.get(level - 1) + root.val);
        dfs(root.left, level + 1, levelSums);
        dfs(root.right, level + 1, levelSums);
    }

}
