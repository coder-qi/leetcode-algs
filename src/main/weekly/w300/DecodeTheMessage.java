package weekly.w300;

/**
 * 2325. 解密消息：https://leetcode.cn/problems/decode-the-message/
 */
public class DecodeTheMessage {

    public static String decodeMessage(String key, String message) {
        char[] replaceChars = new char[26];
        for (int i = 0, j = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch != ' ' && replaceChars[ch - 'a'] == 0) {
                replaceChars[ch - 'a'] = (char) ('a' + j++);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == ' ') {
                ans.append(ch);
            } else {
                ans.append(replaceChars[ch - 'a']);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {

    }

}
