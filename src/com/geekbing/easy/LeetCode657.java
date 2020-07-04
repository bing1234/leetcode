package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        LeetCode657 leetCode657 = new LeetCode657();
        System.out.println(leetCode657.judgeCircle("UD"));
        System.out.println(leetCode657.judgeCircle("LL"));
    }
}
