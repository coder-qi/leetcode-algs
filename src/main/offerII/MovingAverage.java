package offerII;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值：https://leetcode.cn/problems/qIsx9U/
 */
public class MovingAverage {

    int size;
    int sum, len;
    int[] vals;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        vals = new int[size];
    }

    public double next(int val) {
        len++;
        int index = (len - 1) % size;
        if (len > size) {
            sum -= vals[index];
        }
        vals[index] = val;
        sum += val;
        return sum / (double) Math.min(len, size);
    }

}
