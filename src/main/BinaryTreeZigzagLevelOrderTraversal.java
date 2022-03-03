import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new LinkedList<>());
        }
        List<Integer> levelList = result.get(level);
        // 从左往右
        if (level % 2 == 0) {
            levelList.add(root.val);
        } else {
            levelList.add(0, root.val);
        }
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeNode.of(3,9,20,null,null,15,7))); // [[3],[20,9],[15,7]]
        System.out.println(zigzagLevelOrder(TreeNode.of(1))); // [[1]]
        System.out.println(zigzagLevelOrder(null)); // []
        System.out.println(zigzagLevelOrder(TreeNode.of(1,2,3,4,null,null,5))); // [[1],[3,2],[4,5]]
    }

}
