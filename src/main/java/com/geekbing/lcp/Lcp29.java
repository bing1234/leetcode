package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Lcp29 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        // 圈数从0开始定义
        // 第0圈, 共(num - 1) * 4个数字; 前1圈共(num - 1) * 4个数字
        // 第1圈共(num - 3) * 4个数字; 前2圈共(2* num - 2 * 2) * 4个数字
        // 第2圈共(num - 5) * 4个数字; 前3圈共(3* num - 3 * 3) * 4个数字
        // L圈开始的数字应该是 (L * num - L * L) * 4 + 1
        // 先判断坐标属于第几圈
        long l = Math.min(Math.min(xPos, num - 1 - xPos), Math.min(yPos, num - 1 - yPos));
        // 前面的数字
        long pre = (l * num - l * l) * 4 % 9;
        long ans;
        if (xPos == l) {
            // 上
            ans = pre + (yPos - l + 1);
        } else if (xPos == num - 1 - l) {
            // 下
            ans = pre + (num - 2 * l - 1) * 2 + (num - l - yPos);
        } else if (yPos == l) {
            // 左
            ans = pre + (num - 2 * l - 1) * 3 + (num - l - xPos);
        } else {
            // 右
            ans = pre + (num - 2 * l - 1) + (xPos - l + 1);
        }
        ans %= 9;
        return ans == 0L ? 9 : (int) ans;
    }

    @Test
    public void testCase1() {
        Lcp29 lcp29 = new Lcp29();
        assert lcp29.orchestraLayout(3, 0, 2) == 3;
    }

    @Test
    public void testCase2() {
        Lcp29 lcp29 = new Lcp29();
        assert lcp29.orchestraLayout(4, 1, 2) == 5;
    }
}
