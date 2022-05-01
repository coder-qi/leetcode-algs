import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
public class AllElementsInTwoBinarySearchTrees {

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        dfs(root1, result);
        dfs(root2, result);
        Collections.sort(result);
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }

    public static void main(String[] args) {
        System.out.println(getAllElements(TreeNode.of(2,1,4), TreeNode.of(1,0,3)));
        System.out.println(getAllElements(TreeNode.of(1,null,8), TreeNode.of(8,1)));
        System.out.println(getAllElements(TreeNode.of(99,90,null,8,null,7,85,null,null,null,87),
            TreeNode.of(50,2,73,null,34,58,80,21,null,null,64,74,92,10,null,null,68,null,null,89,100,null,null,66,null,84)));
    }

}
