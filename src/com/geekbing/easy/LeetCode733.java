package com.geekbing.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * todo
 * @author bing
 */
public class LeetCode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int initColor) {
        // 按照
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(sr, sc));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> cur = stack.pop();
            // 上
            if (cur.sr - 1 >= 0) {
                if (image[cur.sr - 1][cur.sc] == initColor) {
                    image[cur.sr - 1][cur.sc] = newColor;
                    dfs(image, cur.sr - 1, cur.sc, newColor, initColor);
                }
            }

            // 右
            if (cur.sc + 1 < image[0].length) {
                if (image[cur.sr][cur.sc + 1] == initColor) {
                    image[cur.sr][cur.sc + 1] = newColor;
                    dfs(image, cur.sr, cur.sc + 1, newColor, initColor);
                }
            }

            // 下
            if (cur.sr + 1 < image.length) {
                if (image[cur.sr + 1][cur.sc] == initColor) {
                    image[cur.sr + 1][cur.sc] = newColor;
                    dfs(image, cur.sr + 1, cur.sc, newColor, initColor);
                }
            }

            // 左
            if (cur.sc - 1 >= 0) {
                if (image[cur.sr][cur.sc - 1] == initColor) {
                    image[cur.sr][cur.sc - 1] = newColor;
                    dfs(image, cur.sr, cur.sc - 1, newColor, initColor);
                }
            }
        }
    }

    private static final class Pair<A, B> {
        private A sr;
        private B sc;

        public Pair(A sr, B sc) {
            this.sr = sr;
            this.sc = sc;
        }

        public A getSr() {
            return sr;
        }

        public void setSr(A sr) {
            this.sr = sr;
        }

        public B getSc() {
            return sc;
        }

        public void setSc(B sc) {
            this.sc = sc;
        }
    }

    public static void main(String[] args) {
        LeetCode733 leetCode733 = new LeetCode733();
//        System.out.println(Arrays.deepToString(leetCode733.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(leetCode733.floodFill(new int[][]{{0, 0, 0}, {0, 1, 0}}, 1, 1, 2)));
    }
}
