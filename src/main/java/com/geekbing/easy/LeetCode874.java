package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 * 874. 模拟行走机器人
 *
 * @author bing
 */
public class LeetCode874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] xArr = new int[]{0, 1, 0, -1};
        int[] yArr = new int[]{1, 0, -1, 0};

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // 朝向。北(0)、东(1)、南(2)、西(3)
        int x = 0, y = 0, toward = 0, ans = 0;
        for (int command : commands) {
            if (command == -2) {
                toward = (toward + 3) % 4;
            } else if (command == -1) {
                toward = (toward + 1) % 4;
            } else {
                for (int i = 1; i <= command; i++) {
                    // 尝试走出一步
                    int tempX = x + xArr[toward];
                    int tempY = y + yArr[toward];
                    if (!obstacleSet.contains(tempX + "," + tempY)) {
                        x = tempX;
                        y = tempY;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode874 leetCode874 = new LeetCode874();
        System.out.println(leetCode874.robotSim(new int[]{4, -1, 3}, new int[][]{}));
        System.out.println(leetCode874.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }
}
