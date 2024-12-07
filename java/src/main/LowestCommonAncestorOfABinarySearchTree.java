import java.util.LinkedHashSet;

import util.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 */
public class LowestCommonAncestorOfABinarySearchTree {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            LinkedHashSet<TreeNode> paths1 = new LinkedHashSet<>(16);
            LinkedHashSet<TreeNode> paths2 = new LinkedHashSet<>(16);
            paths(paths1, root, p);
            paths(paths2, root, q);
            TreeNode ans = null;
            for (TreeNode node : paths1) {
                if (paths2.contains(node)) {
                    ans = node;
                }
            }
            return ans;
        }

        private void paths(LinkedHashSet<TreeNode> paths, TreeNode root, TreeNode x) {
            if (root == null) {
                return;
            }
            paths.add(root);
            if (x.val > root.val) {
                paths(paths, root.right, x);
            } else if (x.val < root.val) {
                paths(paths, root.left, x);
            }
        }
    }

}
