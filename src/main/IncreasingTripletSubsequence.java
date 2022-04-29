import static util.ArrayUtils.array;

/**
 * 334. 递增的三元子序列：https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        for (int i = 1, min = nums[0]; i < n; i++) {
            leftMin[i] = min;
            min = Math.min(min, nums[i]);
        }
        int[] rightMax = new int[n];
        for (int i = n - 2, max = nums[n - 1]; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(array("[1,2,3,4,5]"))); // true
        System.out.println(increasingTriplet(array("[5,4,3,2,1]"))); // false
        System.out.println(increasingTriplet(array("[2,1,5,0,4,6]"))); // true
        System.out.println(increasingTriplet(array("[20,100,10,12,5,13]"))); // true
    }

}
