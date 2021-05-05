package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 第一个矩形在第二个的上方、下方、左方、右方，没有交集
        if (rec1[0] >= rec2[2] || rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) {
            return false;
        }
        // 计算水平交集长度
        int rowDis = rec1[0] <= rec2[0] ? Math.min(rec1[2], rec2[2]) - rec2[0] : Math.min(rec2[2], rec1[2]) - rec1[0];
        // 计算垂直交集长度
        int colDis = rec1[1] <= rec2[1] ? Math.min(rec1[3], rec2[3]) - rec2[1] : Math.min(rec2[3], rec1[3]) - rec1[1];
        return rowDis > 0 && colDis > 0;
    }

    public static void main(String[] args) {
        LeetCode836 leetCode836 = new LeetCode836();
        System.out.println(leetCode836.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(leetCode836.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println(leetCode836.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3}));
        System.out.println(leetCode836.isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));
        System.out.println(leetCode836.isRectangleOverlap(new int[]{-1, 0, 1, 1}, new int[]{0, -1, 0, 1}));
    }
}
