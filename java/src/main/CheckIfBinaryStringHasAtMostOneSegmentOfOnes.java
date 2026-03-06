/**
 * 1784. 检查二进制字符串字段：https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public boolean checkOnesSegment(String s) {
        int i = 0;
        for (; i < s.length() && s.charAt(i) == '1'; i++);
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }

}
