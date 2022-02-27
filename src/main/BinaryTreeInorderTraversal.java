import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    public static void main(String[] args) {
        // [1,null,2,3]
        TreeNode root = new TreeNode(1, null,
            new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(inorderTraversal(root)); // [1,3,2]

        // []
        root = null;
        System.out.println(inorderTraversal(root)); // []

        // [1]
        root = new TreeNode(1, null, null);
        System.out.println(inorderTraversal(root)); // [1]
    }
}
