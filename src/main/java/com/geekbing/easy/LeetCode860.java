package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        // 剩余的5元数量，剩余的10元数量
        int fiveNum = 0, tenNum = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 收到一张5元
                fiveNum++;
            } else if (bill == 10) {
                // 收到一张10元，必须要找一张5元
                if (fiveNum == 0) {
                    return false;
                }
                fiveNum--;
                tenNum++;
            } else {
                // 收到一张20，优先用一张10块和一张5块；如果不行，则只能使用三张5块
                if (tenNum != 0) {
                    if (fiveNum == 0) {
                        return false;
                    }
                    tenNum--;
                    fiveNum--;
                } else {
                    if (fiveNum < 3) {
                        return false;
                    }
                    fiveNum = fiveNum - 3;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode860 leetCode860 = new LeetCode860();
        System.out.println(leetCode860.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(leetCode860.lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(leetCode860.lemonadeChange(new int[]{10, 10}));
        System.out.println(leetCode860.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
