/**
 * 1344. 时钟指针的夹角：https://leetcode.cn/problems/angle-between-hands-of-a-clock
 */
public class AngleBetweenHandsOfAClock {

    public double angleClock(int hour, int minutes) {
        int d = Math.abs(hour * 60 - minutes * 11);
        return Math.min(d, 720 - d) / 2.0;
    }

}
