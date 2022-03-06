import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的层序遍历 II：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        System.out.println(levelOrderBottom(TreeNode.of(3,9,20,null,null,15,7)));
    }

}
