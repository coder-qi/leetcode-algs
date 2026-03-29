/**
 * 2839. 判断通过操作能否让字符串相等 I：https://leetcode.cn/problems/check-if-strings-can-be-made-equal-with-operations-i
 */
public class CheckIfStringsCanBeMadeEqualWithOperationsI {

    public boolean canBeEqual(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int n = str1.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && str1[j] != str2[i]) {
                j += 2;
            }
            if (j >= n || str1[j] != str2[i]) {
                return false;
            }
            char t = str1[i];
            str1[i] = str1[j];
            str1[j] = t;
        }
        return true;
    }

}
