/**
 * 面试题 01.05. 一次编辑：https://leetcode.cn/problems/one-away-lcci/
 */
public class OneAwayLcci {

    public static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        if (first.length() < second.length()) {
            return oneEditAway(second, first);
        }
        int left = 0;
        while (left < first.length() && left < second.length()
            && first.charAt(left) == second.charAt(left)) {
            left++;
        }
        int firstRight = first.length() - 1, secondRight = second.length() - 1;
        while (firstRight >= left && secondRight >= left
            && first.charAt(firstRight) == second.charAt(secondRight)) {
            firstRight--;
            secondRight--;
        }
        if (first.length() == second.length()) {
            return left == first.length() || firstRight - left == 0;
        } else {
            return firstRight - left == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple")); // true
        System.out.println(oneEditAway("pales", "pal")); // false
        System.out.println(oneEditAway("pales", "pales")); // true
        System.out.println(oneEditAway("intention", "execution")); // false
        System.out.println(oneEditAway("ab", "bc")); // false
        System.out.println(oneEditAway("teacher", "bleacher")); // false
    }

}
