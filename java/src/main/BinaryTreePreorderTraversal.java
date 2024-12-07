import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 二叉树的前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    result.add(root.val);
                    predecessor.right = root;
                    root = root.left;
                } else {
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(preorderTraversal(TreeNode.of(1,null,2,3)));
        System.out.println(preorderTraversal(null));
        System.out.println(preorderTraversal(TreeNode.of(1)));
        System.out.println(preorderTraversal(TreeNode.of(1,2)));
        System.out.println(preorderTraversal(TreeNode.of(1,null,2)));
        System.out.println(preorderTraversal(TreeNode.of(2,3,null,1)));
    }

}
