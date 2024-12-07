import util.TreeNode;

/**
 * 验证二叉搜索树：https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    long last = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val > last) {
            last = root.val;
        } else {
            return false;
        }
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new ValidateBinarySearchTree().isValidBST(TreeNode.of(2,1,3))); // true
        System.out.println(new ValidateBinarySearchTree().isValidBST(TreeNode.of(5,1,4,null,null,3,6))); // false
        System.out.println(new ValidateBinarySearchTree().isValidBST(TreeNode.of(2,2,2))); // false
        System.out.println(new ValidateBinarySearchTree().isValidBST(TreeNode.of(5,4,6,null,null,3,7))); // false
    }

}
