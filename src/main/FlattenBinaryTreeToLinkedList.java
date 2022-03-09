import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树展开为链表：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    TreeNode last;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(1,2,5,3,4,null,6);
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(root);
    }

}
