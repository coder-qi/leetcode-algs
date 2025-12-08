/**
 * 1925. 统计平方和三元组的数目：https://leetcode.cn/problems/count-square-sum-triples
 */
public class CountSquareSumTriples {

    public int countTriples(int n) {
        int ans = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                double c = Math.sqrt(a * a + b * b);
                if (c > n) {
                    break;
                }
                if (c == (int) c) {
                    ans += 2;
                }
            }
        }
        return ans;
    }

}
