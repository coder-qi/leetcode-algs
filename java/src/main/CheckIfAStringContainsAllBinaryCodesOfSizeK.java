import java.util.HashSet;
import java.util.Set;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串：https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        Set<String> subStrings = new HashSet<>(1 << k);
        for (int i = 0; i <= s.length() - k; i++) {
            subStrings.add(s.substring(i, i + k));
        }
        return subStrings.size() == 1 << k;
    }

    public boolean hasAllCodes2(String s, int k) {
        char[] str = s.toCharArray();
        Set<Integer> subs = new HashSet<>(1 << k);
        int x = 0;
        for (int i = 0; i < str.length; i++) {
            x = (x << 1) | (str[i] - '0');
            if (i < k - 1) {
                continue;
            }
            subs.add(x);
            x ^= (str[i - k + 1] - '0') << (k - 1);
        }
        return subs.size() == 1 << k;
    }

}
