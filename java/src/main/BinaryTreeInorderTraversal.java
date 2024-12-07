import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

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
        System.out.println(inorderTraversal(TreeNode.of(1,null,2,3))); // [1,3,2]

        // []
        System.out.println(inorderTraversal(null)); // []

        // [1]
        System.out.println(inorderTraversal(TreeNode.of(1))); // [1]
    }
}
