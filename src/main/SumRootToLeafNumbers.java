/**
 * 求根节点到叶节点数字之和：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {

    int result = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += val;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

    public static void main(String[] args) {
        System.out.println(new SumRootToLeafNumbers().sumNumbers(TreeNode.of(1,2,3)));
        System.out.println(new SumRootToLeafNumbers().sumNumbers(TreeNode.of(4,9,0,5,1)));
    }

}
