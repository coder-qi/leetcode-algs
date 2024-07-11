/**
 * 1574. 删除最短的子数组使剩余数组有序：https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    public static int findLengthOfShortestSubarray(int[] arr) {
        int N = arr.length;
        int left = 0;
        while (left < N - 1 && arr[left + 1] >= arr[left]) {
            left++;
        }
        int right = N - 1;
        int ans = N - (left + 1);
        while ((right == N - 1 || arr[right] <= arr[right + 1]) && left < right) {
            while (left >= 0 && arr[left] > arr[right]) {
                left--;
            }
            ans = Math.min(ans, right - left - 1);
            right--;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(findLengthOfShortestSubarray(new int[] {1, 2, 3, 10, 4, 2, 3, 5}));
//        System.out.println(findLengthOfShortestSubarray(new int[] {1,2,3,10,0,7,8,9}));
//        System.out.println(findLengthOfShortestSubarray(new int[] {2,2,2,1,1,1}));
        System.out.println(findLengthOfShortestSubarray(new int[] {1,2,3,3,10,1,3,3,5}));
    }

}
