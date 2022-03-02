/**
 * 相同的树：https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        return p.val == q.val && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(isSameTree(TreeNode.of(1,2,3), TreeNode.of(1,2,3))); // true
        System.out.println(isSameTree(TreeNode.of(1,2), TreeNode.of(1,null,2))); // false
        System.out.println(isSameTree(TreeNode.of(1,2,1), TreeNode.of(1,1,2))); // false
    }

}
