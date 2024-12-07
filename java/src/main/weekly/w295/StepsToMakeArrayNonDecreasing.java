package weekly.w295;

import java.util.Deque;
import java.util.LinkedList;

import static util.ArrayUtils.array;

/**
 * 6080. 使数组按非递减顺序排列：https://leetcode.cn/problems/steps-to-make-array-non-decreasing/
 */
public class StepsToMakeArrayNonDecreasing {

    public static int totalSteps(int[] nums) {
        int ans = 0;
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                cnt = Math.max(cnt, stack.pop()[1]);
            }
            cnt = stack.isEmpty() ? 0 : cnt + 1;
            ans = Math.max(ans, cnt);
            stack.push(new int[] {nums[i], cnt});
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(totalSteps(array("[5,3,4,4,7,3,6,11,8,5,11]"))); // 3
        System.out.println(totalSteps(array("[5,14,15,2,11,5,13,15]"))); // 3
        System.out.println(totalSteps(array("[10,1,2,3,4,5,6,1,2,3]"))); // 6
        System.out.println(totalSteps(array("[4,5,7,7,13]"))); // 0
    }

}
