import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import util.TreeNode;

/**
 * 515. 在每个树行中找最大值：https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode x = q.poll();
                max = Math.max(max, x.val);
                if (x.left != null) {
                    q.offer(x.left);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
            }
            result.add(max);
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
