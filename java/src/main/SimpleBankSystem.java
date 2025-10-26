/**
 * 2043. 简易银行系统：https://leetcode.cn/problems/simple-bank-system
 */
public class SimpleBankSystem {

    static class Bank {

        int n;
        long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
            n = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!checkAccount(account1) || !checkAccount(account2)) {
                return false;
            }
            if (balance[account1 - 1] < money) {
                return false;
            }
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (!checkAccount(account)) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (!checkAccount(account)) {
                return false;
            }
            if (balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }

        private boolean checkAccount(int account) {
            return account >= 1 && account <= n;
        }

    }

}
