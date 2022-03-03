import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode root, int i, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() <= i) {
            result.add(new ArrayList<>());
        }
        result.get(i).add(root.val);
        dfs(root.left, i + 1, result);
        dfs(root.right, i + 1, result);
    }

    public static void main(String[] args) {
        System.out.println(levelOrder(TreeNode.of(3,9,20,null,null,15,7))); // [[3],[9,20],[15,7]]
        System.out.println(levelOrder(TreeNode.of(1))); // [1]
        System.out.println(levelOrder(null)); // []
    }

}
