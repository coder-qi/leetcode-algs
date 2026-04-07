/**
 * 2069. 模拟行走机器人 II：https://leetcode.cn/problems/walking-robot-simulation-ii
 */
public class WalkingRobotSimulationII {

    static class Robot {

        static final String[] DIR_MAP = new String[] {"East", "North", "West", "South"};
        static final int[][] DIRS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        private final int width;
        private final int height;
        private int direction = 0;
        private int x;
        private int y;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public void step(int num) {
            num %= (height + width) * 2 - 4;
            while (num > 0) {
                int nextX = x + DIRS[direction][0];
                int nextY = y + DIRS[direction][1];
                if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
                    direction = (direction + 1) % 4;
                    continue;
                }
                x = nextX;
                y = nextY;
                num--;
            }
            if (x == 0 && y == 0) {
                direction = 3;
            }
        }

        public int[] getPos() {
            return new int[] { x, y };
        }

        public String getDir() {
            return DIR_MAP[direction];
        }
    }
}
