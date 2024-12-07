package personal.spring2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * LCP 53. 守护太空城：https://leetcode-cn.com/problems/EJvmW4/
 */
public class LCP53 {

    public static int defendSpaceCity(int[] time, int[] position) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < time.length; i++) {
            List<Integer> list = map.get(time[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(time[i], list);
            }
            list.add(position[i]);
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        System.out.println(map);
        return 0;
    }

    public static void main(String[] args) {
        defendSpaceCity(new int[] {1,2,1}, new int[] {6,3,3});
        defendSpaceCity(new int[] {1,1,1,2,2,3,5}, new int[] {1,2,3,1,2,1,3});
    }

}
