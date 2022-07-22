package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        bfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int newColor, int initColor) {
        if (image[sr][sc] == newColor) {
            return;
        }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(sr, sc));
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.poll();
            // 上
            if (node.sr - 1 >= 0 && image[node.sr - 1][node.sc] == initColor) {
                queue.offer(new Pair<>(node.sr - 1, node.sc));
                image[node.sr - 1][node.sc] = newColor;
            }
            // 右
            if (node.sc + 1 < image[0].length && image[node.sr][node.sc + 1] == initColor) {
                queue.offer(new Pair<>(node.sr, node.sc + 1));
                image[node.sr][node.sc + 1] = newColor;
            }
            // 下
            if (node.sr + 1 < image.length && image[node.sr + 1][node.sc] == initColor) {
                queue.offer(new Pair<>(node.sr + 1, node.sc));
                image[node.sr + 1][node.sc] = newColor;
            }
            // 左
            if (node.sc - 1 >= 0 && image[node.sr][node.sc - 1] == initColor) {
                queue.offer(new Pair<>(node.sr, node.sc - 1));
                image[node.sr][node.sc - 1] = newColor;
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

    @Test
    public void testCase1() {
        LeetCode733 leetCode733 = new LeetCode733();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = leetCode733.floodFill(image, 1, 1, 2);
        int[][] expire = new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        assert Arrays.deepEquals(result, expire);
    }

    @Test
    public void testCase2() {
        LeetCode733 leetCode733 = new LeetCode733();
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 0}};
        int[][] result = leetCode733.floodFill(image, 1, 1, 2);
        int[][] expire = new int[][]{{0, 0, 0}, {0, 2, 0}};
        assert Arrays.deepEquals(result, expire);
    }

    @Test
    public void testCase3() {
        LeetCode733 leetCode733 = new LeetCode733();
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        int[][] result = leetCode733.floodFill(image, 1, 1, 2);
        int[][] expire = new int[][]{{0, 0, 0}, {0, 2, 2}};
        assert Arrays.deepEquals(result, expire);
    }

    @Test
    public void testCase4() {
        LeetCode733 leetCode733 = new LeetCode733();
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        int[][] result = leetCode733.floodFill(image, 1, 1, 1);
        int[][] expire = new int[][]{{0, 0, 0}, {0, 1, 1}};
        assert Arrays.deepEquals(result, expire);
    }
}
