import util.ArrayUtils;

import java.util.*;

/**
 * 2092. 找出知晓秘密的所有专家：https://leetcode.cn/problems/find-all-people-with-secret
 */
public class FindAllPeopleWithSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
        for (int[] meeting : meetings) {
            tm.computeIfAbsent(meeting[2], k -> new ArrayList<>()).add(meeting);
        }
        boolean[] known = new boolean[n];
        known[0] = known[firstPerson] = true;
        for (List<int[]> group : tm.values()) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Set<Integer>> ls = new ArrayList<>();
            int seq = 0;
            for (int[] meeting : group) {
                int x = meeting[0];
                int y = meeting[1];
                Integer index1 = map.get(x);
                Integer index2 = map.get(y);
                if (index1 != null && index2 != null) {
                    if (!index1.equals(index2)) {
                        ls.get(index1).addAll(ls.get(index2));
                        ls.set(index2, ls.get(index1));
                    }
                    continue;
                }
                int index;
                if (index1 == null && index2 == null) {
                    index = seq++;
                    ls.add(new HashSet<>());
                } else {
                    index = index1 != null ? index1 : index2;
                }
                map.put(x, index);
                map.put(y, index);
                ls.get(index).add(x);
                ls.get(index).add(y);
            }
            for (Set<Integer> s : ls) {
                boolean found = false;
                for (int x : s) {
                    if (known[x]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    continue;
                }
                for (int x : s) {
                    known[x] = true;
                }
            }
        }
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (known[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findAllPeople2(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        Set<Integer> known = new HashSet<>();
        known.add(0);
        known.add(firstPerson);
        int m = meetings.length;
        for (int i = 0; i < m;) {
            Map<Integer, List<Integer>> g = new HashMap<>();
            int time = meetings[i][2];
            for (; i < m && meetings[i][2] == time; i++) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                g.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                g.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }

            Set<Integer> visited = new HashSet<>();
            for (int x : g.keySet()) {
                if (known.contains(x) && !visited.contains(x)) {
                    dfs(x, g, visited, known);
                }
            }
        }
        return new ArrayList<>(known);
    }

    private void dfs(int u, Map<Integer, List<Integer>> g, Set<Integer> visited, Set<Integer> known) {
        if (visited.contains(u)) {
            return;
        }
        visited.add(u);
        known.add(u);
        for (int v : g.get(u)) {
            dfs(v, g, visited, known);
        }
    }

    public static void main(String[] args) {
        FindAllPeopleWithSecret app = new FindAllPeopleWithSecret();
        System.out.println(app.findAllPeople2(5, ArrayUtils.matrix("[[1,3,3],[2,0,3],[2,3,3]]"), 4));
    }

}
