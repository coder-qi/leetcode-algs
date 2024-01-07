/**
 * 2384. 最大回文数字：https://leetcode.cn/problems/largest-palindromic-number/description/
 */
public class LargestPalindromicNumber {

    public static String largestPalindromic(String num) {
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }
        StringBuilder ans = new StringBuilder(num.length());
        // 最大的数字往前放，如果次数大于2则必定可以组成一对
        for (int i = count.length - 1; i >= 1; i--) {
            while (count[i] >= 2) {
                ans.append(i);
                count[i] -= 2;
            }
        }
        if (ans.length() > 0) {
            while (count[0] >= 2) {
                ans.append(0);
                count[0] -= 2;
            }
        }
        int r = ans.length();
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] > 0) {
                ans.append(i);
                break;
            }
        }
        for (int i = r - 1; i >= 0 ; i--) {
            ans.append(ans.charAt(i));
        }
        return ans.toString();
    }

}
