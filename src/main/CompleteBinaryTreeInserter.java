import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * 919. 完全二叉树插入器：https://leetcode.cn/problems/complete-binary-tree-inserter/
 */
public class CompleteBinaryTreeInserter {

    public static void main(String[] args) {

    }

}

class CBTInserter {

    TreeNode root;
    List<TreeNode> nodes = new ArrayList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;

        nodes.add(null);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                nodes.add(x);
                if (x.left != null) {
                    q.offer(x.left);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
            }
        }
    }

    public int insert(int val) {
        TreeNode x = new TreeNode(val);
        nodes.add(x);
        int parentIndex = (nodes.size()  -  1) / 2;
        TreeNode parent = nodes.get(parentIndex);
        if ((nodes.size()  -  1) % 2 == 0) {
            parent.left = x;
        } else {
            parent.right = x;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}