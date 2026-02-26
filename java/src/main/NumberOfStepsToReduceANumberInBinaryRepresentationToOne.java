/**
 * 1404. 将二进制表示减到 1 的步骤数：https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
 */
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int ans = 0;
        int carry = 0;
        while (sb.length() > 1) {
            int x = (sb.charAt(sb.length() - 1) - '0') + carry;
            carry = x >> 1;
            x = x & 1;
            if (x == 0) {
                ans++;
            } else {
                carry = 1;
                ans += 2;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        ans += carry;
        return ans;
    }

    public int numSteps2(String s) {
        int ans = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int x = (s.charAt(i) - '0') + carry;
            carry = x >> 1;
            x = x & 1;
            if (x == 0) {
                ans++;
            } else {
                carry = 1;
                ans += 2;
            }
        }
        ans += carry;
        return ans;
    }

}
