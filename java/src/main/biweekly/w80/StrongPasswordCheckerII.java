package biweekly.w80;

/**
 * 6095. 强密码检验器 II：https://leetcode.cn/problems/strong-password-checker-ii/
 */
public class StrongPasswordCheckerII {

    public static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean uppercase = false, lowercase = false, digit = false, specialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowercase = true;
            } else if (Character.isUpperCase(ch)) {
                uppercase = true;
            } else if (Character.isDigit(ch)) {
                digit = true;
            } else if ("!@#$%^&*()-+".indexOf(ch) != -1) {
                specialChar = true;
            }
            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }
        }
        return uppercase && lowercase && digit && specialChar;
    }

    public static void main(String[] args) {

    }

}
