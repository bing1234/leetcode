package com.geekbing.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bing
 */
public class Interview0810 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(sr, sc));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            image[cur.x][cur.y] = newColor;

            // 上
            if (0 <= cur.x - 1 && image[cur.x - 1][cur.y] == oldColor) {
                queue.offer(new Pair<>(cur.x - 1, cur.y));
            }
            // 下
            if (cur.x + 1 <= image.length - 1 && image[cur.x + 1][cur.y] == oldColor) {
                queue.offer(new Pair<>(cur.x + 1, cur.y));
            }
            // 左
            if (0 <= cur.y - 1 && image[cur.x][cur.y - 1] == oldColor) {
                queue.offer(new Pair<>(cur.x, cur.y - 1));
            }
            // 右
            if (cur.y + 1 <= image[0].length - 1 && image[cur.x][cur.y + 1] == oldColor) {
                queue.offer(new Pair<>(cur.x, cur.y + 1));
            }
        }
        return image;
    }

    @Test
    public void testCase1() {
        Interview0810 interview0810 = new Interview0810();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = interview0810.floodFill(image, 1, 1, 2);
        int[][] expire = new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        assert Arrays.deepEquals(image, expire);
    }

    @Test
    public void testCase2() {
        Interview0810 interview0810 = new Interview0810();
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        image = interview0810.floodFill(image, 1, 1, 1);
        int[][] expire = new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        assert Arrays.deepEquals(image, expire);
    }

    static class Pair<A, B> {
        private A x;
        private B y;

        public Pair(A x, B y) {
            this.x = x;
            this.y = y;
        }

        public A getX() {
            return x;
        }

        public void setX(A x) {
            this.x = x;
        }

        public B getY() {
            return y;
        }

        public void setY(B y) {
            this.y = y;
        }
    }
}
