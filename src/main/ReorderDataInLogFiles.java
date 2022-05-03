import java.util.Arrays;

/**
 * 937. 重新排列日志文件：https://leetcode-cn.com/problems/reorder-data-in-log-files/
 */
public class ReorderDataInLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int index1 = log1.indexOf(" ");
            int index2 = log2.indexOf(" ");
            boolean digit1 = log1.charAt(index1 + 1) >= '0' && log1.charAt(index1 + 1) <= '9';
            boolean digit2 = log2.charAt(index2 + 1) >= '0' && log2.charAt(index2 + 1) <= '9';
            if (digit1 && digit2) {
                return 0;
            } else if (digit1 || digit2) {
                return digit1 ? 1 : -1;
            } else {
                String content1 = log1.substring(index1 + 1);
                String content2 = log2.substring(index2 + 1);
                int res = content1.compareTo(content2);
                return res != 0 ? res : log1.substring(0, index1).compareTo(log2.substring(0, index2));
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        // [let1 art can, let3 art zero, let2 own kit dig, dig1 8 1 5 1, dig2 3 6]
        System.out.println(Arrays.toString(reorderLogFiles(new String[] {
            "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
        System.out.println(Arrays.toString(reorderLogFiles(new String[] {
            "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    }

}
