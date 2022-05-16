import util.TreeNode;

/**
 * 面试题 04.06. 后继者：https://leetcode.cn/problems/successor-lcci/
 */
public class SuccessorLcci {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while (node != null) {
            if (p.val < node.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {

    }

}
