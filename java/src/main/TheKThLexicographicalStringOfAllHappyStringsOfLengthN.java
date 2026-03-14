import java.util.ArrayList;
import java.util.List;

/**
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串：https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 */
public class TheKThLexicographicalStringOfAllHappyStringsOfLengthN {

    public String getHappyString(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        dfs(n, 0, nums);
        if (nums.size() < k) {
            return "";
        }
        int num = nums.get(k - 1);
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            char ch = (char) ((num & 3) + 'a' - 1);
            res.append(ch);
            num >>= 2;
        }
        return res.reverse().toString();
    }

    private void dfs(int i, int x, List<Integer> nums) {
        if (i == 0) {
            nums.add(x);
            return;
        }
        int prev = x & 3;
        for (int j = 1; j <= 3; j++) {
            if (j != prev) {
                dfs(i - 1, (x << 2) + j, nums);
            }
        }
    }

    public String getHappyString2(int n, int k) {
        if (k > 3 * (1 << (n - 1))) {
            return "";
        }
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            int count = 1 << (n - i - 1);
            for (int j = 0; j < 3; j++) {
                char ch = (char) ('a' + j);
                if (i > 0 && (res[i - 1] == ch)) {
                    continue;
                }
                if (k <= count) {
                    res[i] = ch;
                    break;
                }
                k -= count;
            }
        }
        return new String(res);
    }

}
