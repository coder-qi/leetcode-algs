package personal.spring2022;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(this.val);
            toString(this, result);
            return "[" + result.toString().replaceAll("(,null)+$", "") + "]";
        }

        private void toString(TreeNode root, StringBuilder result) {
            result.append(',').append(root.left != null ? root.left.val : null);
            result.append(',').append(root.right != null ? root.right.val : null);
            if (root.left != null) {
                toString(root.left, result);
            }
            if (root.right != null) {
                toString(root.right, result);
            }
        }

        public static TreeNode of(Integer... nums) {
            TreeNode root = new TreeNode(nums[0]);
            Queue<TreeNode> stack = new LinkedList<>();
            stack.offer(root);
            int i = 1;
            while (i < nums.length && !stack.isEmpty()) {
                Integer num = nums[i++];
                TreeNode node = stack.poll();
                if (num != null) {
                    TreeNode left = new TreeNode(num);
                    node.left = left;
                    stack.offer(left);
                }
                if (i < nums.length) {
                    num = nums[i++];
                    if (num != null) {
                        TreeNode right = new TreeNode(num);
                        node.right = right;
                        stack.offer(right);
                    }
                }
            }
            return root;
        }

    }