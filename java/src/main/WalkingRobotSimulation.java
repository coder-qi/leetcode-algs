import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 874. 模拟行走机器人：https://leetcode.cn/problems/walking-robot-simulation
 */
public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, TreeSet<Integer>> xMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> yMap = new HashMap<>();
        for (int[] pos : obstacles) {
            xMap.computeIfAbsent(pos[1], _ -> new TreeSet<>()).add(pos[0]);
            yMap.computeIfAbsent(pos[0], _ -> new TreeSet<>()).add(pos[1]);
        }
        // 0: 北, 1: 东, 2: 南，3: 西
        int dir = 0;
        int x = 0, y = 0;
        int ans = 0;
        for (int command : commands) {
            if (command == -2) {
                dir = (dir - 1 + 4) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                if (dir == 0) {
                    if (yMap.containsKey(x)) {
                        TreeSet<Integer> s = yMap.get(x);
                        Integer f = s.higher(y);
                        if (f == null || f > y + command) {
                            y += command;
                        } else {
                            y = f - 1;
                        }
                    } else {
                        y += command;
                    }
                } else if (dir == 2) {
                    if (yMap.containsKey(x)) {
                        TreeSet<Integer> s = yMap.get(x);
                        Integer f = s.lower(y);
                        if (f == null || f < y - command) {
                            y -= command;
                        } else {
                            y = f + 1;
                        }
                    } else {
                        y -= command;
                    }
                } else if (dir == 1) {
                    if (xMap.containsKey(y)) {
                        TreeSet<Integer> s = xMap.get(y);
                        Integer f = s.higher(x);
                        if (f == null || f > x + command) {
                            x += command;
                        } else {
                            x = f - 1;
                        }
                    } else {
                        x += command;
                    }
                } else {
                    if (xMap.containsKey(y)) {
                        TreeSet<Integer> s = xMap.get(y);
                        Integer f = s.lower(x);
                        if (f == null || f < x - command) {
                            x -= command;
                        } else {
                            x = f + 1;
                        }
                    } else {
                        x -= command;
                    }
                }
                ans = Math.max(ans, x * x + y * y);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation app = new WalkingRobotSimulation();
        System.out.println(app.robotSim(new int[] {6,-1,-1,6}, new int[][]{{0, 0}}));
    }

}
