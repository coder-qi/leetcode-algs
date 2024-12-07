/**
 * 779. 第K个语法符号：https://leetcode.cn/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println(new KthSymbolInGrammar().kthGrammar(1, 1)); // 0
        System.out.println(new KthSymbolInGrammar().kthGrammar(2, 1)); // 0
        System.out.println(new KthSymbolInGrammar().kthGrammar(2, 2)); // 1
    }

    public int kthGrammar(int n, int k) {
        return dfs(0, n, k);
    }

    private int dfs(int val, int n, int k) {
        if (k == 1) {
            return val;
        }
        int h = 1 << (n - 2);
        if (k <= h) {
            return dfs(val, n - 1, k);
        } else {
            return dfs(val == 0 ? 1 : 0, n - 1, k - h);
        }
    }

}
