package com.geekbing.lcp;

/**
 * todo
 *
 * @author bing
 */
public class LCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        return false;
    }

    public static void main(String[] args) {
        LCP03 lcp03 = new LCP03();

        int[][] obstacles1 = new int[0][0];
        int[][] obstacles2 = new int[][]{{2, 2}};
        int[][] obstacles3 = new int[][]{{4, 2}};
        System.out.println(lcp03.robot("URR", obstacles1, 3, 2));
        System.out.println(lcp03.robot("URR", obstacles2, 3, 2));
        System.out.println(lcp03.robot("URR", obstacles3, 3, 2));
    }
}
