import java.util.ArrayList;
import java.util.List;

/**
 * 1291. 顺次数：https://leetcode.cn/problems/sequential-digits/
 */
public class SequentialDigits {

    private static final List<Integer> SEQUENTIAL_DIGITS = new ArrayList<>();

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int digit : SEQUENTIAL_DIGITS) {
            if (digit >= low && digit <= high) {
                ans.add(digit);
            }
        }
        return ans;
    }

    static {
        String s = "123456789";
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 0; j + i <= 9; j++) {
                SEQUENTIAL_DIGITS.add(Integer.parseInt(s.substring(j, i + j)));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(SEQUENTIAL_DIGITS);
    }

}
