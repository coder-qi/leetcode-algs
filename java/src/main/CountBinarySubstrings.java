/**
 * 696. 计数二进制子串：https://leetcode.cn/problems/count-binary-substrings
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int j = 0;
        while (j < chars.length - 1 && chars[j] == chars[j + 1]) {
            j++;
        }
        for (int i = 0; i < chars.length - 1;) {
            int k = j + 1;
            while (k < chars.length && chars[k] != chars[i]) {
                if (k - j <= j - i + 1) {
                    ans++;
                }
                k++;
            }
            i = j + 1;
            j = k - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        System.out.println(cbs.countBinarySubstrings("00110011")); // 6
        System.out.println(cbs.countBinarySubstrings("10101")); // 4
        System.out.println(cbs.countBinarySubstrings("1010001")); // 4
    }

}
