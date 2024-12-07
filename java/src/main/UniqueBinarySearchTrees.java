/**
 * 不同的二叉搜索树：https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(1));
        System.out.println(new UniqueBinarySearchTrees().numTrees(2));
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
        System.out.println(new UniqueBinarySearchTrees().numTrees(4));
        System.out.println(new UniqueBinarySearchTrees().numTrees(19));
    }

}
