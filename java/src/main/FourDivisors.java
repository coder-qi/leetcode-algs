/**
 * 1390. 四因数：https://leetcode.cn/problems/four-divisors
 */
public class FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            int s = 0;
            int count = 0;
            for (int i = 1; i * i <= x; i++) {
                if (x % i == 0) {
                    if (i * i != x) {
                        count += 2;
                        s += i;
                        s += x / i;
                    } else {
                        count += 1;
                        s += i;
                    }
                }
                if (count > 4) {
                    break;
                }
            }
            if (count == 4) {
                sum += s;
            }
        }
        return sum;
    }

}
