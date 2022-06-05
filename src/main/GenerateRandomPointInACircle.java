import java.util.Arrays;
import java.util.Random;

/**
 * 478. 在圆内随机生成点：https://leetcode.cn/problems/generate-random-point-in-a-circle/
 */
public class GenerateRandomPointInACircle {

    static class Solution {

        double x, y, radius;
        Random random = new Random();

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x = x_center;
            this.y = y_center;
        }

        public double[] randPoint() {
            while (true) {
                double newX = random.nextDouble() * (2 * radius) - radius;
                double newY = random.nextDouble() * (2 * radius) - radius;
                if (newX * newX + newY * newY <= radius * radius) {
                    return new double[] {newX + x, newY + y};
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
    }


}
