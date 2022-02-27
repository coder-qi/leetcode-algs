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

    public static TreeNode of(Integer... nums) {
        TreeNode root = new TreeNode(nums[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int i = 1;
        while (i < nums.length && !stack.isEmpty()) {
            Integer num = nums[i++];
            TreeNode node = stack.pop();
            if (num != null) {
                TreeNode left = new TreeNode(num);
                node.left = left;
                stack.push(left);
            }
            if (i < nums.length) {
                num = nums[i++];
                if (num != null) {
                    TreeNode right = new TreeNode(num);
                    node.right = right;
                    stack.push(right);
                }
            }
        }
        return root;
    }

}

