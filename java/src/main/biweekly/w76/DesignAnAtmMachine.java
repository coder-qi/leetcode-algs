package biweekly.w76;

import java.util.HashMap;
import java.util.Map;

/**
 * 6062. 设计一个 ATM 机器：https://leetcode-cn.com/problems/design-an-atm-machine/
 */
public class DesignAnAtmMachine {

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[] {0,0,1,2,1}); // 存入 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票。
        atm.withdraw(600);        // 返回 [0,0,1,0,1] 。机器返回 1 张 $100 和 1 张 $500 的钞票。机器里剩余钞票的数量为 [0,0,0,2,0] 。
        atm.deposit(new int[] {0,1,0,1,1}); // 存入 1 张 $50 ，1 张 $200 和 1 张 $500 的钞票。
        // 机器中剩余钞票数量为 [0,1,0,3,1] 。
        atm.withdraw(600);        // 返回 [-1] 。机器会尝试取出 $500 的钞票，然后无法得到剩余的 $100 ，所以取款请求会被拒绝。
        // 由于请求被拒绝，机器中钞票的数量不会发生改变。
        atm.withdraw(550);
    }

    static class ATM {
        static final int N = 5;
        int[] moneyValue = new int[] {20, 50, 100, 200, 500};
        Map<Integer, Long> moneyCount = new HashMap<>() {{
            for (int i = 0; i < N; i++) {
                put(i, 0L);
            }
        }};

        public ATM() {
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                moneyCount.put(i, moneyCount.get(i) + banknotesCount[i]);
            }
        }

        public int[] withdraw(int amount) {
            int[] result = new int[N];
            for (int i = N - 1; i >= 0; i--) {
                long count = Math.min(amount / moneyValue[i], moneyCount.get(i));
                if (count > 0) {
                    result[i] = (int) count;
                    amount -= count * moneyValue[i];
                    if (amount == 0) {
                        break;
                    }
                }
            }
            if (amount == 0) {
                for (int i = 0; i < N; i++) {
                    if (result[i] != 0) {
                        moneyCount.put(i, moneyCount.get(i) - result[i]);
                    }
                }
            }
            return amount != 0 ? new int[] {-1} : result;
        }
    }

}
