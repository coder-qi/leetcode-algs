import java.util.Arrays;

/**
 * 2126. 摧毁小行星：https://leetcode.cn/problems/destroying-asteroids
 */
public class DestroyingAsteroids {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long s = mass;
        for (int asteroid : asteroids) {
            if (asteroid > s) {
                return false;
            }
            s += asteroid;
        }
        return true;
    }

}
