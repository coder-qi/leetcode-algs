import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 扰乱字符串：https://leetcode-cn.com/problems/scramble-string/
 */
public class ScrambleString {

    char[] c1, c2;
    int[][][] memo;
    Map<Character, Integer> cmpMap = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        memo = new int[len][len][len + 1];
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        return dfs(0, 0, len);
    }

    private boolean dfs(int i1, int i2, int len) {
        if (memo[i1][i2][len] != 0) {
            return memo[i1][i2][len] == 1;
        }
        // 子串是否相等
        if (Arrays.equals(c1, i1, i1 + len, c2, i2, i2 + len)) {
            memo[i1][i2][len] = 1;
            return true;
        }
        // 检测字符出现的次数是否一样
        if (!checkIsSimilar(i1, i2, len)) {
            memo[i1][i2][len] = -1;
            return false;
        }
        for (int i = 1; i < len; i++) {
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }
            if (dfs(i1, i2 + len - i, i) && dfs(i1 + i, i2, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }
        }
        memo[i1][i2][len] = -1;
        return false;
    }

    private boolean checkIsSimilar(int i1, int i2, int len) {
        cmpMap.clear();
        for (int i = i1; i < i1 + len; i++) {
            cmpMap.put(c1[i], cmpMap.getOrDefault(c1[i], 0) + 1);
        }
        for (int i = i2; i < i2 + len; i++) {
            Integer cnt = cmpMap.get(c2[i]);
            if (cnt == null) {
                return false;
            }
            if (cnt == 1) {
                cmpMap.remove(c2[i]);
            } else {
                cmpMap.put(c2[i], cnt - 1);
            }
        }
        return cmpMap.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("great", "rgeat"));
        System.out.println(new ScrambleString().isScramble("abcde", "caebd"));
        System.out.println(new ScrambleString().isScramble("a", "a"));
    }

}
