import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 515. 在每个树行中找最大值：https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        } else {
            result.set(level, Integer.max(result.get(level), root.val));
        }
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }

    public static void main(String[] args) {

    }

}
