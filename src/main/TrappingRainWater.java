/**
 * 接雨水：https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        int maxIndex = 0, n = height.length;
        for (int i = 0, max = 0; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int ans = 0, max = height[0], index = 1;
        while (index <= maxIndex) {
            if (height[index] <= max) {
                ans += max - height[index];
            } else {
                max = height[index];
            }
            index++;
        }

        max = height[n - 1];
        index = n - 1;
        while (index >= maxIndex) {
            if (height[index] <= max) {
                ans += max - height[index];
            } else {
                max = height[index];
            }
            index--;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(trap(new int[] {4,2,0,3,2,5})); // 9
        System.out.println(trap(new int[] {2,0,2})); // 2
    }

}
