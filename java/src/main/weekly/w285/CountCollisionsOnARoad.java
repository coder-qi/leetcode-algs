package weekly.w285;

/**
 * 2211. 统计道路上的碰撞次数：https://leetcode.cn/problems/count-collisions-on-a-road/
 */
public class CountCollisionsOnARoad {

    public static int countCollisions(String directions) {
        int left = 0, right = directions.length() - 1;
        while (left < directions.length() && directions.charAt(left) == 'L') {
            left++;
        }
        while (right >= left && directions.charAt(right) == 'R') {
            right--;
        }
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL")); // 5
        System.out.println(countCollisions("LLRR")); // 0
    }

}
