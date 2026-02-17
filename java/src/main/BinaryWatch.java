import java.util.*;

/**
 * 401. 二进制手表：https://leetcode.cn/problems/binary-watch
 */
public class BinaryWatch {

    static Map<Integer, List<String>> hoursMap = new HashMap<>();
    static Map<Integer, List<String>> minutesMap = new HashMap<>();

    static {
        int[] top = new int[] {1, 2, 4, 8};
        int[] bottom = new int[] {1, 2, 4, 8, 16, 32};
        process(hoursMap, top, 11, false);
        process(minutesMap, bottom, 59, true);
    }

    private static void process(Map<Integer, List<String>> map, int[] values, int max, boolean zeroPrefix) {
        int n = values.length;
        for (int x = 0; x <= n; x++) {
            List<Integer> nums = new ArrayList<>();
            process(values, 0, x, 0, nums);
            map.put(x, nums.stream()
                    .filter(num -> num <= max)
                    .map(num -> (zeroPrefix && num < 10 ? "0" : "") + num)
                    .toList());
        }
    }

    private static void process(int[] values, int i, int k, int sum, List<Integer> res) {
        if (k == 0) {
            res.add(sum);
            return;
        }
        if (i >= values.length) {
            return;
        }
        process(values, i + 1, k, sum, res);
        process(values, i + 1, k - 1, sum + values[i], res);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            List<String> hours = hoursMap.get(i);
            List<String> minutes = minutesMap.get(turnedOn - i);
            if (hours == null || minutes == null) {
                continue;
            }
            for (String hour : hours) {
                for (String minute : minutes) {
                    ans.add(hour + ":" + minute);
                }
            }
        }
        return ans;
    }

    static void main() {
        BinaryWatch binaryWatch = new BinaryWatch();
        System.out.println(BinaryWatch.hoursMap);
    }

}
