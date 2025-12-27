import util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import static util.ArrayUtils.matrix;

/**
 * 2402. 会议室 III：https://leetcode.cn/problems/meeting-rooms-iii
 */
public class MeetingRoomsIII {

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int[] cnt = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        TreeSet<Integer> availableRooms = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!pq.isEmpty() && start >= pq.peek()[0]) {
                int[] a = pq.poll();
                availableRooms.add(a[1]);
            }
            if (pq.size() < n) {
                int x = availableRooms.removeFirst();
                cnt[x]++;
                pq.add(new int[]{end, x});
            } else {
                int[] a = pq.poll();
                cnt[a[1]]++;
                pq.add(new int[]{a[0] + end - start, a[1]});
            }
        }
        int ans = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                ans = i;
            }
        }
        return ans;
    }

    public int mostBooked2(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int[] cnt = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!pq.isEmpty() && start >= pq.peek()[0]) {
                int[] a = pq.poll();
                availableRooms.add(a[1]);
            }
            if (pq.size() < n) {
                int x = availableRooms.poll();
                cnt[x]++;
                pq.add(new int[]{end, x});
            } else {
                int[] a = pq.poll();
                cnt[a[1]]++;
                pq.offer(new int[]{a[0] + end - start, a[1]});
            }
        }
        int ans = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MeetingRoomsIII app = new MeetingRoomsIII();
        System.out.println(app.mostBooked2(3, matrix("[[1,20],[2,10],[3,5],[4,9],[6,8]]")));
    }

}
