/**
 * 279. 完全平方数：https://leetcode.cn/problems/perfect-squares/
 */
public class PerfectSquares {

    public static int numSquares(int n) {
        int cnt = 0;
        while (n != 0) {
            int k = (int) Math.ceil(Math.sqrt(n));
            while (n - k >= 0) {
                n -= k;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

}
