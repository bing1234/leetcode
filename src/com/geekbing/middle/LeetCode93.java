package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        return result;
    }

    private boolean isValidIp(int num1, int num2, int num3, int num4) {
        return 0 <= num1 && num1 <= 255 &&
                0 <= num2 && num2 <= 255 &&
                0 <= num3 && num3 <= 255 &&
                0 <= num4 && num4 <= 255;
    }

    public static void main(String[] args) {
        LeetCode93 leetCode93 = new LeetCode93();
        System.out.println(leetCode93.restoreIpAddresses("25525511135"));
    }
}
