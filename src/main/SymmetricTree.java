import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> pStack = new LinkedList<>();
        Deque<TreeNode> qStack = new LinkedList<>();
        TreeNode p = root.left;
        TreeNode q = root.right;
        while (!pStack.isEmpty() || p != null || !qStack.isEmpty() || q != null) {
            while (p != null) {
                pStack.push(p);
                p = p.left;
            }
            while (q != null) {
                qStack.push(q);
                q = q.right;
            }
            if (pStack.size() != qStack.size()) {
                return false;
            }
            p = pStack.pop();
            q = qStack.pop();
            if (p.val != q.val) {
                return false;
            }
            p = p.right;
            q = q.left;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.of(1,2,2,3,4,4,3))); // true
        System.out.println(isSymmetric(TreeNode.of(1,2,2,null,3,null,3))); // false
        System.out.println(isSymmetric(TreeNode.of(2,3,3,4,5,null,4))); // false
    }

}
