/**
 * 面试题 01.09. 字符串轮转：https://leetcode.cn/problems/string-rotation-lcci/
 */
public class StringRotationLcci {

    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat")); // true
        System.out.println(isFlipedString("aa", "aba")); // false
        System.out.println(isFlipedString("", "")); // true
        System.out.println(isFlipedString("abcd", "acdb")); // false
        System.out.println(isFlipedString("eCQOKatuwIPRHFftkBmhQfakidjbtRVwblGdpLTtSLbjFzBwIjobHMsPvyucjIEs",
            "kBmhQfakidjbtRVwblGdpLTtSLbjFzBwIjobHMsPvyucjIEseCQOKatuwIPRHFft")); // true
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        if (n == 0) {
            return true;
        }
        int[][][] count = new int[58][58][2];
        for (int i = 0; i < n; i++) {
            int cur = s1.charAt(i) - 'A',
                prev = s1.charAt((i - 1 + n) % n) - 'A',
                next = s1.charAt((i + 1 + n) % n) - 'A';
            count[cur][prev][0]++;
            count[cur][next][1]++;
        }
        for (int i = 0; i < n; i++) {
            int cur = s2.charAt(i) - 'A',
                prev = s2.charAt((i - 1 + n) % n) - 'A',
                next = s2.charAt((i + 1 + n) % n) - 'A';
            count[cur][prev][0]--;
            count[cur][next][1]--;
            if (count[cur][prev][0] < 0 || count[cur][next][1] < 0) {
                return false;
            }
        }
        return true;
    }

}
