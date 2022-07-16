package offerII;

import java.util.LinkedList;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值：https://leetcode.cn/problems/qIsx9U/
 */
public class MovingAverage {

    int size;
    int sum;
    LinkedList<Integer> vals = new LinkedList<>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (vals.size() == size) {
            sum -= vals.removeFirst();
        }
        sum += val;
        vals.add(val);
        return sum / (double) vals.size();
    }

}
