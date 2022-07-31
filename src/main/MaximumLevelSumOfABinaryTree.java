import java.util.ArrayDeque;
import java.util.Deque;

import util.TreeNode;

/**
 * 1161. 最大层内元素和：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 */
public class MaximumLevelSumOfABinaryTree {

    public static void main(String[] args) {

    }

    public static int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 1, ansLevel = 1, maxSum = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                sum += x.val;
                if (x.left != null) {
                    q.offer(x.left);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ansLevel = level;
            }
            level++;
        }
        return ansLevel;
    }

}
