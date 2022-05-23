import util.TreeNode;

/**
 * 965. 单值二叉树：https://leetcode.cn/problems/univalued-binary-tree/
 */
public class UnivaluedBinaryTree {

    public static boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private static boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && dfs(root.left, val) && dfs(root.right, val);
    }

    public static void main(String[] args) {
        System.out.println(isUnivalTree(TreeNode.of(1,1,1,1,1,null,1))); // true
        System.out.println(isUnivalTree(TreeNode.of(2,2,2,5,2))); // false
    }

}
