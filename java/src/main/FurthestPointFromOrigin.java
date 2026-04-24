/**
 * 2833. 距离原点最远的点：https://leetcode.cn/problems/furthest-point-from-origin
 */
public class FurthestPointFromOrigin {

    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0;
        int rCount = 0;
        int _Count = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                rCount++;
            } else if (c == 'L') {
                lCount++;
            } else {
                _Count++;
            }
        }
        return Math.abs(rCount - lCount) + _Count;
    }

}
