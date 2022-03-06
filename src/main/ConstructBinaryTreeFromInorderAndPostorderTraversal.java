import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    int postorderIndex;
    int[] postorder;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int j = 0; j < inorder.length; j++) {
            inorderMap.put(inorder[j], j);
        }
        this.postorder = postorder;
        this.postorderIndex = postorder.length - 1;
        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end || postorderIndex < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderIndex--]);
        int i = inorderMap.get(root.val);
        root.right = buildTree(i + 1, end);
        root.left = buildTree(start, i - 1);
        return root;
    }

    public static TreeNode buildMyTree(int[] preorder, int[] inorder) {
        return new ConstructBinaryTreeFromInorderAndPostorderTraversal()
            .buildTree(preorder, inorder);
    }

    public static void main(String[] args) {
        System.out.println(buildMyTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3}));
    }

}
