import java.util.Map;
import java.util.TreeMap;

/**
 * 732. 我的日程安排表 III：https://leetcode.cn/problems/my-calendar-iii/
 */
public class MyCalendarIII {

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        myCalendarThree.book(5, 10); // 返回 3
        myCalendarThree.book(25, 55); // 返回 3
    }

    static class MyCalendarThree {

        Map<Integer, Integer> count = new TreeMap<>();

        public MyCalendarThree() {
        }

        public int book(int start, int end) {
            count.put(start, count.getOrDefault(start, 0) + 1);
            count.put(end, count.getOrDefault(end, 0) - 1);
            int ans = 0;
            int maxBook = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                maxBook += entry.getValue();
                ans = Math.max(ans, maxBook);
            }
            return ans;
        }
    }

}
