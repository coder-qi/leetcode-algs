/**
 * 加油站：https://leetcode-cn.com/problems/gas-station/
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, result = -1;
        int total = 0, rightSum = 0;
        for (int i = 0; i < n; i++) {
            int c = gas[i] - cost[i];
            if (rightSum + c < 0) {
                rightSum = 0;
                result = -1;
            } else {
                if (result == -1) {
                    result = i;
                }
                rightSum += c;
            }
            total += c;
        }
        return total >= 0 ? result : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
        System.out.println(canCompleteCircuit(new int[] {2}, new int[] {2}));
        System.out.println(canCompleteCircuit(new int[] {6,1,4,3,5}, new int[] {3,8,2,4,2}));
        System.out.println(canCompleteCircuit(new int[] {3,1,1}, new int[] {1,2,2}));
    }

}
