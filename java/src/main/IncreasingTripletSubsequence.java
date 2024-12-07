import static util.ArrayUtils.array;

/**
 * 334. 递增的三元子序列：https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
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
        System.out.println(increasingTriplet(array("[2,4,-2,-3]"))); // true
    }

}
