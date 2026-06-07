import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2196. 根据描述创建二叉树：https://leetcode.cn/problems/create-binary-tree-from-descriptions
 */
public class CreateBinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>(descriptions.length, 1.0f);
        Map<TreeNode, TreeNode> parents = new HashMap<>(descriptions.length, 1.0f);
        for (int[] desc : descriptions) {
            TreeNode parent = nodes.computeIfAbsent(desc[0], _ -> new TreeNode(desc[0]));
            TreeNode child = nodes.computeIfAbsent(desc[1], _ -> new TreeNode(desc[1]));
            parents.put(child, parent);
            if (desc[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        TreeNode x = nodes.get(descriptions[0][0]);
        while (parents.containsKey(x)) {
            x = parents.get(x);
        }
        return x;
    }

}
