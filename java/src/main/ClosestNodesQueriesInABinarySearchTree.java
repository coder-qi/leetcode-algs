import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import util.TreeNode;

/**
 * 2476. 二叉搜索树最近节点查询：https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree
 */
public class ClosestNodesQueriesInABinarySearchTree {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        buildTree(root, treeSet);
        List<List<Integer>> res = new ArrayList<>(queries.size());
        for (int x : queries) {
           Integer min = treeSet.floor(x);
           if (min == null) {
               min = -1;
           }
           Integer max = treeSet.ceiling(x);
           if (max == null) {
               max = -1;
           }
           res.add(Arrays.asList(min, max));
        }
        return res;
    }

    private void buildTree(TreeNode root, TreeSet<Integer> treeSet) {
        if (root == null) {
            return;
        }
        treeSet.add(root.val);
        buildTree(root.left, treeSet);
        buildTree(root.right, treeSet);
    }

}
