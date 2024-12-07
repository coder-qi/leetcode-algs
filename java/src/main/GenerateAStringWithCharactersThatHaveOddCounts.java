/**
 * 1374. 生成每种字符都是奇数个的字符串：https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
public class GenerateAStringWithCharactersThatHaveOddCounts {

    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        StringBuilder ans = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            ans.append('a');
        }
        if (n % 2 == 0) {
            ans.setCharAt(ans.length() - 1, 'b');
        }
        return ans.toString();
    }

}
