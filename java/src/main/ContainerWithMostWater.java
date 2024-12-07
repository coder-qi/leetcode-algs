/**
 * 盛最多水的容器：https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /**
     * 暴力解法：时间复杂度O(N^2)
     */
    public static int maxAreaBruteForce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 左右指针法：移动值较小的指针，后续才有机会使得容器的面积最大
     * 时间复杂度：O(N)
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            ans = Math.max(ans, h * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[]{1,1})); // 1
        System.out.println(maxArea(new int[]{4,3,2,1,4})); // 16
        System.out.println(maxArea(new int[]{1,2,1})); // 2
        System.out.println(maxArea(new int[]{1,8,100,2,100,4,8,3,7})); // 200
    }

}
