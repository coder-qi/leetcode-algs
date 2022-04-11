import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                if (i == 0) {
                    result.add(x.val);
                }
                if (x.right != null) {
                    q.offer(x.right);
                }
                if (x.left != null) {
                    q.offer(x.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(rightSideView(TreeNode.of(1,2,3,null,5,null,4))); // [1,3,4]
        System.out.println(rightSideView(TreeNode.of(1,null,3))); // [1,3]
        System.out.println(rightSideView(null)); // []
        System.out.println(rightSideView(TreeNode.of(1,2,3,4))); // [1,3,4]
    }

}
