import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II：https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum(root, targetSum, result, list);
        return result;
    }

    private static void pathSum(TreeNode root, int targetSum,
        List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        } else {
            pathSum(root.left, targetSum - root.val, result, list);
            pathSum(root.right, targetSum - root.val, result, list);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        // [[5,4,11,2],[5,8,4,5]]
        System.out.println(pathSum(TreeNode.of(5,4,8,11,null,13,4,7,2,null,null,5,1), 22));

        // []
        System.out.println(pathSum(TreeNode.of(1,2,3), 5));
        // []
        System.out.println(pathSum(TreeNode.of(1,2), 0));
    }

}
