import java.util.Arrays;
import java.util.Comparator;

/**
 * 1331. 数组序号转换：https://leetcode.cn/problems/rank-transform-of-an-array/
 */
public class RankTransformOfAnArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[] {40,10,20,30}))); // [4,1,2,3]
        System.out.println(Arrays.toString(arrayRankTransform(new int[] {100,100,100}))); // [1,1,1]
        System.out.println(Arrays.toString(arrayRankTransform(new int[] {37,12,28,9,100,56,80,5,12}))); // [5,3,4,2,8,6,7,1,3]
    }

    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[] {arr[i], i};
        }
        Arrays.sort(nums, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[n];
        for (int i = 0, j = 1; i < n; i++) {
            ans[nums[i][1]] = j;
            if (i != n - 1 && nums[i][0] != nums[i + 1][0]) {
                j++;
            }
        }
        return ans;
    }

}
