import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

/**
 * 二叉树的后序遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        TreeNode p = null, r = root;
        while (root != null) {
            if (root.left != null) {
                p = root.left;
                while (p.right != null && p.right != root) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                } else {
                    p.right = null;
                    addPath(result, root.left);
                    root = root.right;
                }
            } else {
                root = root.right;
            }
        }

        addPath(result, r);
        return result;
    }

    private static void addPath(LinkedList<Integer> result, TreeNode node) {
        int count = 0;
        while (node != null) {
            result.add(node.val);
            node = node.right;
            count++;
        }
        int left = result.size() - count, right = result.size() - 1;
        while (left < right) {
            int t = result.get(left);
            result.set(left, result.get(right));
            result.set(right, t);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(postorderTraversal(TreeNode.of(1,null,2,3)));
        System.out.println(postorderTraversal(TreeNode.of(1,11,2,3,4,null,null,5,6)));
    }

}
