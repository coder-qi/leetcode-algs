import java.util.Deque;
import java.util.LinkedList;

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
        /*StringBuilder result = new StringBuilder();
        result.append(this.val);
        toString(this, result);
        return "[" + result.toString() + "]";*/
        return String.valueOf(val);
    }

    private void toString(TreeNode root, StringBuilder result) {
        if (root.left == null && root.right == null) {
            return;
        }
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
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int i = 1;
        while (i < nums.length && !stack.isEmpty()) {
            Integer num = nums[i++];
            TreeNode node = stack.pop();
            TreeNode left = null, right = null;
            if (num != null) {
                left = new TreeNode(num);
                node.left = left;
            }
            if (i < nums.length) {
                num = nums[i++];
                if (num != null) {
                    right = new TreeNode(num);
                    node.right = right;
                }
            }
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
        return root;
    }

}

