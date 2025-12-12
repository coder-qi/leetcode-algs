import util.ListUtils;

import java.util.*;

/**
 * 3433. 统计用户被提及情况：https://leetcode.cn/problems/count-mentions-per-user
 */
public class CountMentionsPerUser {

    public int[] countMentions(int n, List<List<String>> events) {
        int[] ans = new int[n];
        events.sort(this::compareTimestamp);
        int all = 0;
        int[] nextOnlineTime = new int[n];
        for (List<String> event : events) {
            String eventType = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            String content = event.get(2);
            if ("MESSAGE".equals(eventType)) {
                if ("ALL".equals(content)) {
                    all++;
                } else if ("HERE".equals(content)) {
                    for (int i = 0; i < n; i++) {
                        if (nextOnlineTime[i] <= timestamp) {
                            ans[i]++;
                        }
                    }
                } else {
                    for (String id : content.split(" ")) {
                        int index = Integer.parseInt(id.substring(2));
                        ans[index]++;
                    }
                }
            } else {
                int userId = Integer.parseInt(content);
                nextOnlineTime[userId] = timestamp + 60;
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] += all;
        }
        return ans;
    }

    private int compareTimestamp(List<String> e1, List<String> e2) {
        String eventType1 = e1.get(0);
        int ts1 = Integer.parseInt(e1.get(1));
        int ts2 = Integer.parseInt(e2.get(1));
        String eventType2 = e2.get(0);
        return ts1 == ts2 ? eventTypeCmp(eventType1) - eventTypeCmp(eventType2) : Integer.compare(ts1, ts2);
    }

    private int eventTypeCmp(String eventType) {
        return "OFFLINE".equals(eventType) ? 0 : 1;
    }

    public static void main(String[] args) {
        CountMentionsPerUser app = new CountMentionsPerUser();
        System.out.println(Arrays.toString(app.countMentions(
                2, Arrays.asList(
                        Arrays.asList("OFFLINE", "10", "0"),
                        Arrays.asList("MESSAGE", "12", "HERE")))
        ));
        System.out.println(Arrays.toString(app.countMentions(
                3, Arrays.asList(
                        Arrays.asList("MESSAGE","1","ALL"),
                        Arrays.asList("OFFLINE","66","1"),
                        Arrays.asList("MESSAGE","66","HERE"),
                        Arrays.asList("OFFLINE","5","1")))
        ));
        System.out.println(Arrays.toString(app.countMentions(
                5, ListUtils.toNested("[[\"OFFLINE\",\"28\",\"1\"],[\"OFFLINE\",\"14\",\"2\"],[\"MESSAGE\",\"2\",\"ALL\"],[\"MESSAGE\",\"28\",\"HERE\"],[\"OFFLINE\",\"66\",\"0\"],[\"MESSAGE\",\"34\",\"id2\"],[\"MESSAGE\",\"83\",\"HERE\"],[\"MESSAGE\",\"40\",\"id3 id3 id2 id4 id4\"]]")
        )));
    }

}
