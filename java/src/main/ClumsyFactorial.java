import java.util.ArrayList;
import java.util.List;

/**
 * 1006. 笨阶乘：https://leetcode.cn/problems/clumsy-factorial
 */
public class ClumsyFactorial {

    public int clumsy(int n) {
        char[] ops = new char[] {'*', '/', '+', '-'};
        List<Integer> nums = new ArrayList<>();
        int ans = n;
        for (int i = n - 1, j = 0; i >= 1; i--, j++) {
            char op = ops[j % 4];
            switch (op) {
                case '*' ->  ans *= i;
                case '/' ->  ans /= i;
                case '+' ->  ans += i;
                case '-' -> {
                    nums.add(ans);
                    ans = -i;
                }
            }
        }
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }

    public int clumsy2(int n) {
        char[] ops = new char[] {'*', '/', '+', '-'};
        int num = n;
        int ans = 0;
        for (int i = n - 1, j = 0; i >= 1; i--, j++) {
            char op = ops[j % 4];
            switch (op) {
                case '*' ->  num *= i;
                case '/' ->  num /= i;
                case '+' ->  num += i;
                case '-' -> {
                    ans += num;
                    num = -i;
                }
            }
        }
        ans += num;
        return ans;
    }

}
