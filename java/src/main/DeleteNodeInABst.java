import util.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点：https://leetcode.cn/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInABst {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                TreeNode x = root.right;
                while (x.left != null) {
                    x = x.left;
                }
                x.left = root.left;
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(deleteNode(TreeNode.of(5,3,6,2,4,null,7), 3));
        System.out.println(deleteNode(TreeNode.of(5,3,6,2,4,null,7), 0));
        System.out.println(deleteNode(TreeNode.of(8,0,31,null,6,28,45,1,7,25,30,32,49,null,4,null,
            null,9,26,29,null,null,42,47,null,2,5,null,12,null,27,null,null,41,43,46,48,null,3,null,
            null,10,19,null,null,33,null,null,44,null,null,null,null,null,null,null,11,18,20,null,37,
            null,null,null,null,14,null,null,22,36,38,13,15,21,24,34,null,null,39,null,null,null,16,null,
            null,23,null,null,35,null,40,null,17), 1));
    }

}
