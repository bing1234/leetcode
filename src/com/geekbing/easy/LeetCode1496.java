package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1496 {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> points = new HashSet<>();
        points.add(x + "," + y);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    break;
            }
            if (points.contains(x + "," + y)) {
                return true;
            }
            points.add(x + "," + y);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1496 leetCode1496 = new LeetCode1496();
        System.out.println(leetCode1496.isPathCrossing("NES"));
        System.out.println(leetCode1496.isPathCrossing("NESWW"));
    }
}
