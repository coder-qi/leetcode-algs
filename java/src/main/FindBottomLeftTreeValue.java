import java.util.ArrayDeque;
import java.util.Deque;

import util.TreeNode;

/**
 * 513. 找树左下角的值：https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int ans = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode x = q.poll();
                if (x.right != null) {
                    q.offer(x.right);
                }
                if (x.left != null) {
                    q.offer(x.left);
                }
                ans = x.val;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
