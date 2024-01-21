/**
 * 367. 有效的完全平方数：https://leetcode.cn/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        for (long i = 0; i * i <= num; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

}
