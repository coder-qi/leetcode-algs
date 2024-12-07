

package biweekly.w79;

/**
 * 10011. 以组为单位订音乐会的门票：https://leetcode.cn/problems/booking-concert-tickets-in-groups/
 */
public class BookingConcertTicketsInGroups {

    public static void main(String[] args) {
        BookMyShow bms = new BookMyShow(2, 5); // 总共有 2 排，每排 5 个座位。
        bms.gather(4, 0); // 返回 [0, 0]
        // 这一组安排第 0 排 [0, 3] 的座位。
        bms.gather(2, 0); // 返回 []
        // 第 0 排只剩下 1 个座位。
        // 所以无法安排 2 个连续座位。
        bms.scatter(5, 1); // 返回 True
        // 这一组安排第 0 排第 4 个座位和第 1 排 [0, 3] 的座位。
        bms.scatter(5, 1); // 返回 False
        // 总共只剩下 2 个座位。
    }

}

class BookMyShow {

    int n, m;
    int[] min;
    long[] sum;

    public BookMyShow(int n, int m) {
        this.n = n;
        this.m = m;
        min = new int[4 * n];
        sum = new long[4 * n];
    }

    public int[] gather(int k, int maxRow) {
        int i = index(1, 1, n, maxRow + 1, m - k);
        if (i == 0) {
            return new int[] {};
        }
        int seats = (int) querySum(1, 1, n, i, i);
        add(1, 1, n, i, i, k);
        return new int[] {i - 1, seats};
    }

    public boolean scatter(int k, int maxRow) {
        if ((long)(maxRow + 1) * m - querySum(1, 1, n, 1, maxRow + 1) < k) {
            return false;
        }
        for (int i = index(1, 1, n, maxRow + 1, m - 1); ; i++) {
            int leftSeats = (int) (m - querySum(1, 1, n, i, i));
            if (k <= leftSeats) {
                add(1, 1, n, i, i, k);
                break;
            }
            k -= leftSeats;
            add(1, 1, n, i, i, leftSeats);
        }
        return true;
    }

    void add(int i, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            min[i] += val;
            sum[i] += val;
            return;
        }
        int mid = (start + end) >> 1;
        if (l <= mid) {
            add(i * 2, start, mid, l, r, val);
        }
        if (mid < r) {
            add(i * 2 + 1, mid + 1, end, l, r, val);
        }

        min[i] = Math.min(min[i * 2], min[i * 2 + 1]);
        sum[i] = sum[i * 2] + sum[i * 2 + 1];
    }

    long querySum(int i, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return sum[i];
        }
        long sum = 0;
        int mid = (start + end) >> 1;
        if (l <= mid) {
            sum += querySum(i * 2, start, mid, l, r);
        }
        if (mid < r) {
            sum += querySum(i * 2 + 1, mid + 1, end, l, r);
        }
        return sum;
    }

    int index(int i, int start, int end, int r, int val) {
        if (min[i] > val) {
            return 0;
        }
        if (start == end) {
            return start;
        }
        int mid = (start + end) >> 1;
        if (min[i * 2] <= val) {
            return index(i * 2, start, mid, r, val);
        }
        if (mid < r) {
            return index(i * 2 + 1, mid + 1, end, r, val);
        }
        return 0;
    }
}
