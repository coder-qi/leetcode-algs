import com.sun.source.tree.Tree;

/**
 * 对称二叉树：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        return p.val == q.val && isSymmetric(p.left, q.right)
                    && isSymmetric(p.right, q.left);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.of(1,2,2,3,4,4,3))); // true
        System.out.println(isSymmetric(TreeNode.of(1,2,2,null,3,null,3))); // false
    }

}
