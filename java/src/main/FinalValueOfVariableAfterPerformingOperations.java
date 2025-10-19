/**
 * 2011. 执行操作后的变量值：https://leetcode.cn/problems/final-value-of-variable-after-performing-operations
 */
public class FinalValueOfVariableAfterPerformingOperations {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            switch (operation) {
                case "++X":
                case "X++": x++; break;
                case "--X":
                case "X--": x--; break;
            }
        }
        return x;
    }

}
