/**
 * 验证回文串：https://leetcode-cn.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int leftVal = 0;
            while (left < right && (leftVal = normal(s.charAt(left))) == 0) {
                left++;
            }
            int rightVal = 0;
            while (left < right && (rightVal = normal(s.charAt(right))) == 0) {
                right--;
            }
            if (left != right && leftVal != rightVal) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static int normal(char c) {
        c = Character.toLowerCase(c);
        return Character.isLetterOrDigit(c) ? c : 0;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("a."));
    }

}
