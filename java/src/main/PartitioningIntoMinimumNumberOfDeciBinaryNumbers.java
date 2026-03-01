/**
 * 1689. 十-二进制数的最少数目：https://leetcode.cn/problems/partitioning-into-minimum-number-of-deci-binary-numbers
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int ans = 1;
        for (char ch : n.toCharArray()) {
            ans = Math.max(ans, ch - '0');
        }
        return ans;
    }

}
