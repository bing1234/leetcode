package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1041 {
    public boolean isRobotBounded(String instructions) {
        // 位置坐标
        int x = 0, y = 0;
        // 0: 北、1: 东、2: 南、3: 西
        int direction = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            switch (c) {
                case 'G':
                    switch (direction) {
                        case 0:
                            y++;
                            break;
                        case 1:
                            x++;
                            break;
                        case 2:
                            y--;
                            break;
                        default:
                            x--;
                            break;
                    }
                    break;
                case 'L':
                    direction--;
                    if (direction < 0) {
                        direction = 3;
                    }
                    break;
                case 'R':
                    direction++;
                    if (direction == 4) {
                        direction = 0;
                    }
                    break;
            }
        }
        return (x == 0 && y == 0) || (direction != 0);
    }

    @Test
    public void testCase1() {
        LeetCode1041 leetCode1041 = new LeetCode1041();
        assert leetCode1041.isRobotBounded("GGLLGG");
    }

    @Test
    public void testCase2() {
        LeetCode1041 leetCode1041 = new LeetCode1041();
        assert !leetCode1041.isRobotBounded("GG");
    }

    @Test
    public void testCase3() {
        LeetCode1041 leetCode1041 = new LeetCode1041();
        assert leetCode1041.isRobotBounded("GL");
    }
}
