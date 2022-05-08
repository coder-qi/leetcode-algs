import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * 二叉树的层序遍历：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();
            result.add(levelList);
            for (int i = 0; i < len && !queue.isEmpty(); i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(levelOrder(TreeNode.of(3,9,20,null,null,15,7))); // [[3],[9,20],[15,7]]
        System.out.println(levelOrder(TreeNode.of(1))); // [1]
        System.out.println(levelOrder(null)); // []
    }

}
