import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static util.ArrayUtils.matrix;

/**
 * 253. 会议室 II：https://leetcode-cn.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() <= intervals[i][0]) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(matrix("[[0,30],[5,10],[15,20]]"))); // 2
        System.out.println(minMeetingRooms(matrix("[[7,10],[2,4]]"))); // 1
        System.out.println(minMeetingRooms(matrix("[[2,11],[6,16],[11,16]]"))); // 2
    }

}
