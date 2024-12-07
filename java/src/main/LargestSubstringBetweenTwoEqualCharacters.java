import java.util.Arrays;

/**
 * 1624. 两个相同字符之间的最长子字符串：https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {

    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[][] indexes = new int[26][2];
        for (int[] p : indexes) {
            Arrays.fill(p, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            int[] p = indexes[s.charAt(i) - 'a'];
            if (p[0] == -1) {
                p[0] = i;
            }
            p[1] = i;
        }
        int ans = -1;
        for (int[] p : indexes) {
            ans = Math.max(ans, p[1] - p[0] - 1);
        }
        return ans;
    }

}
