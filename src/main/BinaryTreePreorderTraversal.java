import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode x = stack.pop();
            result.add(x.val);
            if (x.right != null) {
                stack.push(x.right);
            }
            if (x.left != null) {
                stack.push(x.left);
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
