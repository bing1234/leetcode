package com.geekbing.lcs;

/**
 * @author bing
 */
public class LcsO1 {
    public int leastMinutes(int n) {
        int ans = 0;
        // 当前带宽量
        int cur = 1;
        while (true) {
            if (n <= cur) {
                ans++;
                break;
            } else {
                cur *= 2;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LcsO1 lcsO1 = new LcsO1();

        System.out.println(lcsO1.leastMinutes(2));
        System.out.println(lcsO1.leastMinutes(4));
    }
}
