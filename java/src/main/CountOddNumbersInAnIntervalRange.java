/**
 * 1523. 在区间范围内统计奇数数目：https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range
 */
public class CountOddNumbersInAnIntervalRange {

    public int countOdds(int low, int high) {
        return ((high + 1) >> 1) - (low >> 1);
    }

}
