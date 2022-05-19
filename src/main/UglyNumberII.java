/**
 * 264. 丑数 II：https://leetcode.cn/problems/ugly-number-ii/
 */
public class UglyNumberII {

    public static int nthUglyNumber(int n) {
        boolean[] ugly = new boolean[n + 1];
        for (int i = 1; i <= n / 2; i++) {
            ugly[2 * i] = true;
            if (3 * i <= n) {
                ugly[3 * i] = true;
            }
            if (5 * i <= n) {
                ugly[5 * i] = true;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (ugly[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

}
