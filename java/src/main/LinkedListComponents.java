import java.util.Arrays;

/**
 * 817. 链表组件：https://leetcode.cn/problems/linked-list-components/
 */
public class LinkedListComponents {

    public static void main(String[] args) {

    }

    public static int numComponents(ListNode head, int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        boolean[] arr = new boolean[max + 1];
        for (int num : nums) {
            arr[num] = true;
        }
        int ans = 0;
        boolean first = false;
        while (head != null) {
            if (head.val <= max && arr[head.val]) {
                if (!first) {
                    first = true;
                    ans++;
                }
            } else {
                first = false;
            }
            head = head.next;
        }
        return ans;
    }

}
