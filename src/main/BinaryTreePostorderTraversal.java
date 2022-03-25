import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                result.addFirst(root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(postorderTraversal(TreeNode.of(1,null,2,3)));
        System.out.println(postorderTraversal(TreeNode.of(1,11,2,3,4,null,null,5,6)));
    }

}
