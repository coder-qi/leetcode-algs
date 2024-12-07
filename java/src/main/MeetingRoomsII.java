import java.util.Arrays;

import static util.ArrayUtils.matrix;

/**
 * 253. 会议室 II：https://leetcode-cn.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        int[] startTimings = new int[intervals.length],
            endTimings = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTimings[i] = intervals[i][0];
            endTimings[i] = intervals[i][1];
        }
        Arrays.sort(startTimings);
        Arrays.sort(endTimings);
        int ans = 0;
        for (int startIndex = 0, endIndex = 0; startIndex < startTimings.length; startIndex++) {
            if (startTimings[startIndex] >= endTimings[endIndex]) {
                endIndex++;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(matrix("[[0,30],[5,10],[15,20]]"))); // 2
        System.out.println(minMeetingRooms(matrix("[[7,10],[2,4]]"))); // 1
        System.out.println(minMeetingRooms(matrix("[[2,11],[6,16],[11,16]]"))); // 2
    }

}
