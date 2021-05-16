package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode1018 leetCode1018 = new LeetCode1018();
        System.out.println(leetCode1018.prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println(leetCode1018.prefixesDivBy5(new int[]{1, 1, 1}));
        System.out.println(leetCode1018.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        System.out.println(leetCode1018.prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
    }
}
