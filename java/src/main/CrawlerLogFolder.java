/**
 * 1598. 文件夹操作日志搜集器：https://leetcode.cn/problems/crawler-log-folder/
 */
public class CrawlerLogFolder {

    public static void main(String[] args) {

    }

    public static int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else if (!log.equals("./")) {
                depth++;
            }
        }
        return depth;
    }

}
