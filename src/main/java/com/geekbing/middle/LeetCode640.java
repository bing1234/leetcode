package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode640 {
    public String solveEquation(String equation) {
        String[] items = equation.split("=");
        int[] left = parseEquation(items[0]);
        int[] right = parseEquation(items[1]);
        int baseX = left[0] - right[0];
        int baseNum = right[1] - left[1];
        if (baseX == 0 && baseNum == 0) {
            return "Infinite solutions";
        }
        if (baseX == 0) {
            return "No solution";
        }
        return "x=" + (baseNum / baseX);
    }

    private int[] parseEquation(String equation) {
        int idx = 0, baseX = 0, baseNum = 0;
        boolean add = true;
        while (idx < equation.length()) {
            char c = equation.charAt(idx);
            switch (c) {
                case '+':
                    add = true;
                    idx++;
                    break;
                case '-':
                    add = false;
                    idx++;
                    break;
                case 'x':
                    if (add) {
                        baseX++;
                    } else {
                        baseX--;
                    }
                    add = true;
                    idx++;
                    break;
                default:
                    // 数字
                    int num = 0;
                    while (idx < equation.length() && '0' <= equation.charAt(idx) && equation.charAt(idx) <= '9') {
                        num = num * 10 + equation.charAt(idx) - '0';
                        idx++;
                    }
                    // 数字后面紧跟着x的情况
                    if (idx < equation.length() && equation.charAt(idx) == 'x') {
                        if (add) {
                            baseX += num;
                        } else {
                            baseX -= num;
                        }
                        idx++;
                    } else {
                        if (add) {
                            baseNum += num;
                        } else {
                            baseNum -= num;
                        }
                    }
                    add = true;
                    break;
            }
        }
        return new int[]{baseX, baseNum};
    }

    @Test
    public void testCase1() {
        LeetCode640 leetCode640 = new LeetCode640();
        assert leetCode640.solveEquation("x+5-3+x=6+x-2").equals("x=2");
    }

    @Test
    public void testCase2() {
        LeetCode640 leetCode640 = new LeetCode640();
        assert leetCode640.solveEquation("x=x").equals("Infinite solutions");
    }

    @Test
    public void testCase3() {
        LeetCode640 leetCode640 = new LeetCode640();
        assert leetCode640.solveEquation("2x=x").equals("x=0");
    }

    @Test
    public void testCase4() {
        LeetCode640 leetCode640 = new LeetCode640();
        assert leetCode640.solveEquation("x=100").equals("x=100");
    }
}
