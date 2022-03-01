/**
 * 恢复二叉搜索树：https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {

    TreeNode first, second, last;

    public void recoverTree(TreeNode root) {
        dfs(root);

        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (last != null && last.val > root.val) {
            if (first == null) {
                first = last;
            }
            second = root;
        }
        last = root;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(1, 3, null, null, 2);
        new RecoverBinarySearchTree().recoverTree(root);
        System.out.println(root);

        root = TreeNode.of(3, 1, 4, null, null, 2);
        new RecoverBinarySearchTree().recoverTree(root);
        System.out.println(root);
    }

}
