package personal.spring2022;

import java.util.TreeSet;

/**
 * LCP 52. 二叉搜索树染色：https://leetcode-cn.com/problems/QO5KpG/
 */
public class LCP52 {

    TreeSet<Integer> nums = new TreeSet<>();

    public int getNumber(TreeNode root, int[][] ops) {
        dfs(root);

        int ans = 0;
        for (int i = ops.length - 1; i >= 0; i--) {
            int type = ops[i][0], x = ops[i][1], y = ops[i][2];
            for (int j = x; j <= y;) {
                if (nums.remove(j) && type == 1) {
                    ans++;
                }
                Integer next = nums.ceiling(j + 1);
                if (next == null) {
                    break;
                }
                j = next;
                if (nums.isEmpty()) {
                    return ans;
                }
            }
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new LCP52().
            getNumber(TreeNode.of(1,null,2,null,3,null,4,null,5),
                new int[][] {
                    {1,2,4},{1,1,3},{0,3,5}
                }
            )); // 2
        System.out.println(new LCP52().
            getNumber(TreeNode.of(4,2,7,1,null,5,null,null,null,null,6),
                new int[][] {
                    {0,2,2},{1,1,5},{0,4,5},{1,5,7}
                }
        )); // 5
    }
}
