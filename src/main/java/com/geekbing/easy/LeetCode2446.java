package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        return compareDate(event1[1], event2[0]) != -1 && compareDate(event2[1], event1[0]) != -1;
    }

    private int compareDate(String date1, String date2) {
        int hour1 = Integer.parseInt(date1.substring(0, 2));
        int min1 = Integer.parseInt(date1.substring(3, 5));
        int hour2 = Integer.parseInt(date2.substring(0, 2));
        int min2 = Integer.parseInt(date2.substring(3, 5));
        int flag = Integer.compare(hour1, hour2);
        if (flag != 0) {
            return flag;
        }
        return Integer.compare(min1, min2);
    }

    @Test
    public void testCase1() {
        LeetCode2446 leetCode2446 = new LeetCode2446();
        assert leetCode2446.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"});
    }

    @Test
    public void testCase2() {
        LeetCode2446 leetCode2446 = new LeetCode2446();
        assert leetCode2446.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"});
    }

    @Test
    public void testCase3() {
        LeetCode2446 leetCode2446 = new LeetCode2446();
        assert !leetCode2446.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"});
    }
}