import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 面试题 04.06. 后继者：https://leetcode.cn/problems/successor-lcci/
 */
public class SuccessorLcci {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        int index = list.indexOf(p);
        if (index != -1 && index < list.size() - 1) {
            return list.get(index + 1);
        }
        return null;
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public static void main(String[] args) {

    }

}
