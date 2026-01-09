import util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 865. 具有所有最深节点的最小子树：https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    int depth = -1;
    Set<TreeNode> nodes;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        parentMap = new HashMap<>();
        nodes = new HashSet<>();
        dfs(root, 0);

        Set<TreeNode> parentNodes = new HashSet<>();
        while (nodes.size() > 1) {
            for (TreeNode node : nodes) {
                parentNodes.add(parentMap.get(node));
            }
            Set<TreeNode> t = nodes;
            nodes = parentNodes;
            parentNodes = t;
            parentNodes.clear();
        }
        return nodes.iterator().next();
    }

    private void dfs(TreeNode x, int depth) {
        if (depth > this.depth) {
            this.depth = depth;
            nodes.clear();
        }
        if (this.depth == depth) {
            nodes.add(x);
        }
        if (x.left != null) {
            parentMap.put(x.left, x);
            dfs(x.left, depth + 1);
        }
        if (x.right != null) {
            parentMap.put(x.right, x);
            dfs(x.right, depth + 1);
        }
    }

    static class Solution2 {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root, 0).node;
        }

        private Info dfs(TreeNode x, int depth) {
            if (x == null) {
                return new Info(null, -1);
            }
            if (x.left == null && x.right == null) {
                return new Info(x, depth);
            } else {
                Info leftInfo = dfs(x.left, depth + 1);
                Info rightInfo = dfs(x.right, depth + 1);
                if (leftInfo.depth == rightInfo.depth) {
                    return new Info(x, leftInfo.depth);
                } else {
                    return leftInfo.depth > rightInfo.depth ? leftInfo : rightInfo;
                }
            }
        }

        static class Info {
            TreeNode node;
            int depth;

            public Info(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 app = new Solution2();
        System.out.println(app.subtreeWithAllDeepest(TreeNode.of(0, 1, 2, 3, 7, 4, 5, 6, 8, null, 9)));
    }

}
