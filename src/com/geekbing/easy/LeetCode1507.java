package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1507 {
    private static final Map<String, String> MONTH_MAP = new HashMap<>(16);

    static {
        MONTH_MAP.put("Jan", "01");
        MONTH_MAP.put("Feb", "02");
        MONTH_MAP.put("Mar", "03");
        MONTH_MAP.put("Apr", "04");
        MONTH_MAP.put("May", "05");
        MONTH_MAP.put("Jun", "06");
        MONTH_MAP.put("Jul", "07");
        MONTH_MAP.put("Aug", "08");
        MONTH_MAP.put("Sep", "09");
        MONTH_MAP.put("Oct", "10");
        MONTH_MAP.put("Nov", "11");
        MONTH_MAP.put("Dec", "12");
    }

    public String reformatDate(String date) {
        String[] arrs = date.split(" ");

        List<String> months = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        int mon = months.indexOf(arrs[1]) + 1;
        String month = mon > 9 ? String.valueOf(mon) : "0" + mon;

        String day = arrs[0].length() == 3 ? "0" + arrs[0].substring(0, 1) : arrs[0].substring(0, 2);
        return arrs[2] + "-" + month + "-" + day;
    }

    public String reformatDateV2(String date) {
        String[] arrs = date.split(" ");
        String day = arrs[0].length() == 3 ? "0" + arrs[0].substring(0, 1) : arrs[0].substring(0, 2);
        return arrs[2] + "-" + MONTH_MAP.get(arrs[1]) + "-" + day;
    }

    public static void main(String[] args) {
        LeetCode1507 leetCode1507 = new LeetCode1507();
        System.out.println(leetCode1507.reformatDateV2("20th Oct 2052"));
        System.out.println(leetCode1507.reformatDateV2("6th Jun 1933"));
        System.out.println(leetCode1507.reformatDateV2("26th May 1960"));
    }
}
