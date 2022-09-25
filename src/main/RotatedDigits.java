/**
 * 788. 旋转数字：https://leetcode.cn/problems/rotated-digits/
 */
public class RotatedDigits {

    public static void main(String[] args) {
        System.out.println(rotatedDigits(10)); // 4
        System.out.println(rotatedDigits(10000)); // 4
    }

    public static int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean f1 = false, f2 = false;
            int m = i;
            while (m != 0) {
                int a = m % 10;
                if (a == 2 || a == 5 || a == 6 || a == 9) {
                    f1 = true;
                } else if (a != 0 && a !=1 && a != 8) {
                    f2 = true;
                    break;
                }
                m /= 10;
            }
            if (f1 && !f2) {
                ans++;
            }
        }
        return ans;
    }

}
