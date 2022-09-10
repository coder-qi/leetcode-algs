import util.TreeNode;

/**
 * 669. 修剪二叉搜索树：https://leetcode.cn/problems/trim-a-binary-search-tree/
 */
public class TrimABinarySearchTree {

    public static void main(String[] args) {

    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

}
