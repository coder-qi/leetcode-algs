import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 二叉树的右视图：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }
        dfs(root.right, level + 1, result);
        dfs(root.left, level + 1, result);
    }

    public static void main(String[] args) {
        System.out.println(rightSideView(TreeNode.of(1,2,3,null,5,null,4))); // [1,3,4]
        System.out.println(rightSideView(TreeNode.of(1,null,3))); // [1,3]
        System.out.println(rightSideView(null)); // []
        System.out.println(rightSideView(TreeNode.of(1,2,3,4))); // [1,3,4]
    }

}
