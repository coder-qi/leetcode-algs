import java.util.ArrayList;
import java.util.List;

/**
 * 2130. 链表最大孪生和：https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list
 */
public class MaximumTwinSumOfALinkedList {

    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();
        dfs(head, values);
        int ans = 0;
        int n = values.size();
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, values.get(i) + values.get(n - 1 - i));
        }
        return ans;
    }

    private void dfs(ListNode head, List<Integer> values) {
        if (head == null) {
            return;
        }
        values.add(head.val);
        dfs(head.next, values);
    }

}
