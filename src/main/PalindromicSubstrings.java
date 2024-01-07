/**
 * 647. 回文子串：https://leetcode.cn/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {

    public static int countSubstrings2(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 以i为中心的回文个数
            for (int p = i, q = i; p >= 0 && q < n && arr[q] == arr[p]; p--, q++) {
                ans++;
            }
            // 以i, i + 1为中心的回文个数
            for (int p = i, q = i + 1; p >= 0 && q < n && arr[q] == arr[p]; p--, q++) {
                ans++;
            }
        }
        return ans;
    }

    public static int countSubstrings(String s) {
        // 混入#字符
        char[] str = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            str[2 * i] = '#';
            str[2 * i + 1] = s.charAt(i);
        }
        str[str.length - 1] = '#';

        int ans = 0;

        int C = -1; // 回文中心点
        int R = -1; // 回文右侧对称点 + 1
        int[] pArr = new int[str.length]; // 回文半径数组
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[C - (i - C)], R - i) : 1;

            while (i - pArr[i] >= 0 && i + pArr[i] < str.length
                && str[i - pArr[i] ] == str[i + pArr[i] ]) {
                pArr[i]++;
            }

            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            ans += pArr[i] / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc")); // 3
        System.out.println(countSubstrings("aaa")); // 6
    }

}
