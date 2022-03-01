import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树：https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNode.of(2,1,3))); // true
        System.out.println(isValidBST(TreeNode.of(5,1,4,null,null,3,6))); // false
        System.out.println(isValidBST(TreeNode.of(2,2,2))); // false
        System.out.println(isValidBST(TreeNode.of(5,4,6,null,null,3,7))); // false
    }

}
