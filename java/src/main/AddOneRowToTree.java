import util.TreeNode;

/**
 * 623. 在二叉树中增加一行：https://leetcode.cn/problems/add-one-row-to-tree/
 */
public class AddOneRowToTree {

    public static void main(String[] args) {

    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

}
