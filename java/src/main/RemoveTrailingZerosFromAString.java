/**
 * 2710. 移除字符串中的尾随零：https://leetcode.cn/problems/remove-trailing-zeros-from-a-string
 */
public class RemoveTrailingZerosFromAString {

    public String removeTrailingZeros(String num) {
        int lastIndex = num.length();
        while (lastIndex > 0 && num.charAt(lastIndex - 1) == '0') {
            lastIndex--;
        }
        return num.substring(0, lastIndex);
    }

}
