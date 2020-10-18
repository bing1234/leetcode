package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/swap-adjacent-in-lr-string/
 * 777. 在LR字符串中交换相邻字符
 *
 * @author bing
 */
public class LeetCode777 {
    public boolean canTransform(String start, String end) {
        // 1. 长度必须相等
        if (start.length() != end.length()) {
            return false;
        }

        // 2. L、R数量必须相等
        int sl = 0, sr = 0, el = 0, er = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                sl++;
            } else if (start.charAt(i) == 'R') {
                sr++;
            }
            if (end.charAt(i) == 'L') {
                el++;
            } else if (end.charAt(i) == 'R') {
                er++;
            }
        }
        if (sl != el || sr != er) {
            return false;
        }

        // 3. L配对的话start的下标必须大于等于end的下标；R配对的话，start的下标必须小于等于end的下标
        int idxS = 0, idxE = 0;
        while (idxS < start.length() && idxE < end.length()) {
            if (start.charAt(idxS) == end.charAt(idxE)) {
                if (start.charAt(idxS) == 'L' && idxS < idxE) {
                    return false;
                }
                if (start.charAt(idxS) == 'R' && idxS > idxE) {
                    return false;
                }
                idxS++;
                idxE++;
            } else if (start.charAt(idxS) == 'X') {
                idxS++;
            } else if (end.charAt(idxE) == 'X') {
                idxE++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode777 leetCode777 = new LeetCode777();
//        System.out.println(leetCode777.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(leetCode777.canTransform("XXRXLXRXXX", "XXRLXXXXXR"));
    }
}
