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
            double r = Math.sqrt(random.nextDouble()) * radius;
            double theta = random.nextDouble() * 2 * Math.PI;
            return new double[] {x + r * Math.cos(theta), y + r * Math.sin(theta)};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
    }


}
