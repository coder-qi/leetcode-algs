import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

/**
 * 不同的二叉搜索树 II：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    allTrees.add(cur);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(1));
        System.out.println(generateTrees(3));
    }

}
