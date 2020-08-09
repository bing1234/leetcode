package com.geekbing.lcp;

import java.util.HashSet;
import java.util.Set;

/**
 * todo
 *
 * @author bing
 */
public class LCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        if (x > 0 && !command.contains("R")) {
            return false;
        }
        if (y > 0 && !command.contains("U")) {
            return false;
        }
        // 障碍物
        Set<String> points = new HashSet<>();
        for (int[] arr : obstacles) {
            points.add(arr[0] + "," + arr[1]);
        }
        int pointX = 0, pointY = 0;
        while (true) {
            for (char c : command.toCharArray()) {
                if (pointX == x && pointY == y) {
                    return true;
                }
                if (c == 'U') {
                    pointY++;
                } else if (c == 'R') {
                    pointX++;
                }
                if (points.contains(pointX + "," + pointY)) {
                    return false;
                }
                if (pointX > x && pointY > y) {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LCP03 lcp03 = new LCP03();

        int[][] obstacles1 = new int[0][0];
        int[][] obstacles2 = new int[][]{{2, 2}};
        int[][] obstacles3 = new int[][]{{4, 2}};
        System.out.println(lcp03.robot("URR", obstacles1, 3, 2));
        System.out.println(lcp03.robot("URR", obstacles2, 3, 2));
        System.out.println(lcp03.robot("URR", obstacles3, 3, 2));
    }
}
