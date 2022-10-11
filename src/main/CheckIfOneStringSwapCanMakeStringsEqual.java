/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等：https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {

    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index1 == -1) {
                    index1 = i;
                } else {
                    index2 = i;
                    break;
                }
            }
        }
        if (index1 == -1 && index2 == -1) {
            return true;
        }
        if (index1 == -1 || index2 == -1
            || s1.charAt(index1) != s2.charAt(index2)
            || s1.charAt(index2) != s2.charAt(index1)) {
            return false;
        }
        for (int i = index2 + 1; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
