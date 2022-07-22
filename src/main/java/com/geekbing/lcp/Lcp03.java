package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * todo
 *
 * @author bing
 */
public class Lcp03 {
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

    @Test
    public void testCase1() {
        Lcp03 lcp03 = new Lcp03();
        assert lcp03.robot("URR", new int[][]{}, 3, 2);
    }

    @Test
    public void testCase2() {
        Lcp03 lcp03 = new Lcp03();
        assert !lcp03.robot("URR", new int[][]{{2, 2}}, 3, 2);
    }

    @Test
    public void testCase3() {
        Lcp03 lcp03 = new Lcp03();
        assert lcp03.robot("URR", new int[][]{{4, 2}}, 3, 2);
    }
}
