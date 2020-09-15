package com.geekbing.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        // 验证行
        for (char[] chars : board) {
            if (!isValid(chars)) {
                return false;
            }
        }
        // 验证列
        for (int i = 0; i < 9; i++) {
            char[] chars = new char[9];
            for (int j = 0; j < 9; j++) {
                chars[j] = board[j][i];
            }
            if (!isValid(chars)) {
                return false;
            }
        }
        // 验证小三角形
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int index = 0;
                char[] chars = new char[9];
                for (int i = row * 3; i < row * 3 + 3; i++) {
                    for (int j = col * 3; j < col * 3 + 3; j++) {
                        chars[index++] = board[i][j];
                    }
                }
                if (!isValid(chars)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[] nums) {
        Set<Character> set = new HashSet<>();
        for (char num : nums) {
            if (num == '.') {
                continue;
            }
            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode36 leetCode36 = new LeetCode36();
        char[][] board1 = new char[9][9];
        board1[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board1[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board1[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board1[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board1[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board1[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board1[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board1[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board1[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println(leetCode36.isValidSudoku(board1));

        char[][] board2 = new char[9][9];
        board2[0] = new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'};
        board2[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board2[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board2[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board2[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board2[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board2[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board2[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board2[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println(leetCode36.isValidSudoku(board2));

        char[][] board3 = new char[9][9];
        board3[0] = new char[]{'.', '.', '.', '3', '.', '.', '.', '1', '.'};
        board3[1] = new char[]{'.', '.', '.', '.', '.', '7', '.', '.', '.'};
        board3[2] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        board3[3] = new char[]{'.', '.', '.', '.', '.', '8', '2', '7', '.'};
        board3[4] = new char[]{'1', '.', '.', '.', '.', '.', '.', '.', '.'};
        board3[5] = new char[]{'.', '.', '.', '5', '.', '.', '.', '.', '.'};
        board3[6] = new char[]{'2', '.', '.', '.', '8', '.', '.', '.', '7'};
        board3[7] = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        board3[8] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        System.out.println(leetCode36.isValidSudoku(board3));
    }
}
