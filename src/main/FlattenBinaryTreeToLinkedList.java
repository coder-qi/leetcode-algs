import util.TreeNode;

/**
 * 二叉树展开为链表：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
       TreeNode cur = root;
       while (cur != null) {
           if (cur.left != null) {
               TreeNode next = cur.left;
               TreeNode predecessor = next;
               while (predecessor.right != null) {
                   predecessor = predecessor.right;
               }
               predecessor.right = cur.right;
               cur.left = null;
               cur.right = next;
           }
           cur = cur.right;
       }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(1,2,5,3,4,null,6);
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(root);
    }

}
