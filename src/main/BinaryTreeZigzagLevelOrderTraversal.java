import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        boolean lr = true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> zigzagLevel = new ArrayList<>();
            result.add(zigzagLevel);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = lr ? queue.pollFirst() : queue.pollLast();
                zigzagLevel.add(node.val);

                if (lr) {
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
            }

            lr = !lr;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeNode.of(3,9,20,null,null,15,7))); // [[3],[20,9],[15,7]]
        System.out.println(zigzagLevelOrder(TreeNode.of(1))); // [[1]]
        System.out.println(zigzagLevelOrder(null)); // []
        System.out.println(zigzagLevelOrder(TreeNode.of(1,2,3,4,null,null,5))); // [[1],[3,2],[4,5]]
    }

}
