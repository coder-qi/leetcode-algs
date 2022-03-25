import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        System.out.println(postorderTraversal(TreeNode.of(1,null,2,3)));
    }

}
