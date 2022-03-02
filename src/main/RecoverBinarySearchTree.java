/**
 * 恢复二叉搜索树：https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }

        int t = x.val;
        x.val = y.val;
        y.val = t;
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
