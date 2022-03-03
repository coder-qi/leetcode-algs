import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int preindex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int j = 0; j < inorder.length; j++) {
            inorderMap.put(inorder[j], j);
        }
        this.preorder = preorder;
        return buildTree(0, preorder.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end || preindex >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preindex++]);
        int i = inorderMap.get(root.val);
        if (i > start && i < end) {
            root.left = buildTree(0, i - 1);
            root.right = buildTree(i + 1, inorderMap.size() - 1);
        }
        return root;
    }

    public static TreeNode buildMyTree(int[] preorder, int[] inorder) {
        return new ConstructBinaryTreeFromPreorderAndInorderTraversal()
            .buildTree(preorder, inorder);
    }


    public static void main(String[] args) {
        System.out.println(buildMyTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    }

}
