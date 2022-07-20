import util.TreeNode;

/**
 * 814. 二叉树剪枝：https://leetcode.cn/problems/binary-tree-pruning/
 */
public class BinaryTreePruning {

    public static void main(String[] args) {
        System.out.println(pruneTree(TreeNode.of(1,null,0,0,1)));
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null) {
            return root.val == 0 ? null : root;
        }
        return root;
    }

}
