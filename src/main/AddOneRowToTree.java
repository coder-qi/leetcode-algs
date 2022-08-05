import java.util.ArrayDeque;
import java.util.Queue;

import util.TreeNode;

/**
 * 623. 在二叉树中增加一行：https://leetcode.cn/problems/add-one-row-to-tree/
 */
public class AddOneRowToTree {

    public static void main(String[] args) {

    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode x = new TreeNode(val);
            x.left = root;
            return x;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        int curDepth = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            if (curDepth == depth - 1) {
                while (!q.isEmpty()) {
                    TreeNode x = q.poll();
                    x.left = new TreeNode(val, x.left, null);
                    x.right = new TreeNode(val, null, x.right);
                }
            } else {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode x = q.poll();
                    if (x.left != null) {
                        q.offer(x.left);
                    }
                    if (x.right != null) {
                        q.offer(x.right);
                    }
                }
            }
           curDepth++;
        }
        return root;
    }

}
