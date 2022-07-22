package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode6055 {
    public int convertTime(String current, String correct) {
        int currentHour = Integer.parseInt(current.substring(0, 2));
        int currentMinute = Integer.parseInt(current.substring(3, 5));
        int correctHour = Integer.parseInt(correct.substring(0, 2));
        int correctMinute = Integer.parseInt(correct.substring(3, 5));
        // 计算一共相差多少分钟
        int minuteDiff = correctHour * 60 + correctMinute - currentHour * 60 - currentMinute;
        int ans = 0;
        if (minuteDiff >= 60) {
            ans += minuteDiff / 60;
            minuteDiff %= 60;
        }
        if (minuteDiff >= 15) {
            ans += minuteDiff / 15;
            minuteDiff %= 15;
        }
        if (minuteDiff >= 5) {
            ans += minuteDiff / 5;
            minuteDiff %= 5;
        }
        ans += minuteDiff;
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6055 leetCode6055 = new LeetCode6055();
        assert leetCode6055.convertTime("02:30", "04:35") == 3;
    }

    @Test
    public void testCase2() {
        LeetCode6055 leetCode6055 = new LeetCode6055();
        assert leetCode6055.convertTime("11:00", "11:01") == 1;
    }
}
