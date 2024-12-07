/**
 * 回文数：https://leetcode-cn.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    /**
     * 思路：先转换成字符串，然后比较字符串左侧和右侧对称的字符是否相等即可
     */
    public static boolean isPalindromeUsingString(int x) {
        String s = Integer.toString(x);
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 思路：负数肯定不是回文数，如果是回文数，其反转过后也必定也是相等的
     */
    public static boolean isPalindromeReverse(int x) {
        // 负数肯定不是回文数
        if (x < 0) {
            return false;
        }
        long rev = 0;
        int y = x;
        while (y != 0) {
            int digit = y % 10;
            y = y / 10;
            rev = rev * 10 + digit;
        }
        return rev == x;
    }

    /**
     * 思路：比较数字的左半部分和右半部分相等即可知道其是回文数
     *
     * 时间复杂度：O(log N)
     * 控件复杂度：O(1)
     */
    public static boolean isPalindrome(int x) {
        // 负数肯定不是回文数
        // 同样，结尾为0的数字肯定也不是回文数，0除外
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // 奇数位情况，例如121，最终得到的rev为12，x为1，可以通过rev/10去除中文数，再进行比较
        // 偶数位情况，例如2112，最终得到的rev为21，x为21，比较rev==x即可
        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(-121)); // false
        System.out.println(isPalindrome(10)); // false
        System.out.println(isPalindrome(-101)); // false
    }

}
