import java.util.TreeSet;

/**
 * 729. 我的日程安排表 I：https://leetcode.cn/problems/my-calendar-i/
 */
public class MyCalendarI {

    static class MyCalendar {

        TreeSet<int[]> calendars = new TreeSet<>((a, b) -> {
            if (a[0] >= b[1]) {
                return 1;
            } else if (a[1] <= b[0]) {
                return -1;
            } else {
                return 0;
            }
        });

        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            int[] range = new int[] {start, end};
            return calendars.add(range);
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));; // return True
        System.out.println(myCalendar.book(15, 25));; // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        System.out.println(myCalendar.book(20, 30));; // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
    }

}
