package weekly.w288;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 按奇偶性交换后的最大数字：https://leetcode-cn.com/contest/weekly-contest-288/problems/largest-number-after-digit-swaps-by-parity/
 */
public class LargestNumberAfterDigitSwapsByParity {

    public static int largestInteger(int num) {
        String str = Integer.toString(num);
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c - '0') % 2 == 0) {
                even.add(c - '0');
            } else {
                odd.add(c - '0');
            }
        }
        Collections.sort(odd, (v1, v2) -> v2 - v1);
        Collections.sort(even, (v1, v2) -> v2 - v1);
        StringBuilder result = new StringBuilder();
        for (int i = 0, o = 0, e = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c - '0') % 2 == 0) {
                result.append(even.get(e++));
            } else {
                result.append(odd.get(o++));
            }
        }
        return Integer.valueOf(result.toString());
    }

    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
        System.out.println(largestInteger(65875));
    }

}
