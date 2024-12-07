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
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
