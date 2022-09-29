/**
 * 面试题 01.09. 字符串轮转：https://leetcode.cn/problems/string-rotation-lcci/
 */
public class StringRotationLcci {

    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat")); // true
        System.out.println(isFlipedString("aa", "aba")); // false
        System.out.println(isFlipedString("", "")); // true
        System.out.println(isFlipedString("abcd", "acdb")); // true
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        if (n == 0) {
            return true;
        }
        for (int p2 = 0; p2 < n; p2++) {
            int i = 0, j = p2;
            while (i < n && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j = (j + 1) % n;
            }
            if (i == n) {
                return true;
            }
        }
        return false;
    }

}
