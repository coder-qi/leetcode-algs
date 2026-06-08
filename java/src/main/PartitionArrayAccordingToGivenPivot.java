import java.util.Arrays;

/**
 * 2161. 根据给定数字划分数组：https://leetcode.cn/problems/partition-array-according-to-given-pivot/
 */
public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] less = new int[n];
        int[] greater = new int[n];
        int lessIndex = 0;
        int greaterIndex = 0;
        for (int num : nums) {
            if (num < pivot) {
                less[lessIndex++] = num;
            } else if (num > pivot) {
                greater[greaterIndex++] = num;
            }
        }
        int[] result = new int[n];
        System.arraycopy(less, 0, result, 0, lessIndex);
        System.arraycopy(greater, 0, result, n - greaterIndex, greaterIndex);
        Arrays.fill(result, lessIndex, n - greaterIndex, pivot);
        return result;
    }

}
