/**
 * 不同的二叉搜索树：https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return numTrees(1, n);
    }

    private int numTrees(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            int leftCount = numTrees(start, i - 1);
            int rightCount = numTrees(i + 1, end);
            count += leftCount * rightCount;
        }
        memo[start][end] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(1));
        System.out.println(new UniqueBinarySearchTrees().numTrees(2));
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
        System.out.println(new UniqueBinarySearchTrees().numTrees(4));
        System.out.println(new UniqueBinarySearchTrees().numTrees(19));
    }

}
