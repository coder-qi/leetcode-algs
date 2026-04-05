/**
 * 657. 机器人能否返回原点：https://leetcode.cn/problems/robot-return-to-origin
 */
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'R') {
                y++;
            } else if (ch == 'L') {
                y--;
            } else if (ch == 'U') {
                x--;
            } else {
                x++;
            }
        }
        return x == 0 && y == 0;
    }

}
