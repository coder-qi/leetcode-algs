package weekly.w298;

/**
 * 5242. 兼具大小写的最好英文字母：https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/
 */
public class GreatestEnglishLetterInUpperAndLowerCase {

    public static String greatestLetter(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                arr[ch - 'a'] |= 1;
            } else {
                arr[ch - 'A'] |= 2;
            }
        }
        String ans = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 3) {
                ans = String.valueOf((char) ('A' + i));
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
