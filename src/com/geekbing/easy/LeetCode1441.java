package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i = 1;
        for (int num : target) {
            if (num == i) {
                result.add("Push");
                i++;
            } else {
                while (i < num) {
                    result.add("Push");
                    result.add("Pop");
                    i++;
                }
                result.add("Push");
                i = num + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1441 leetCode1441 = new LeetCode1441();
        System.out.println(leetCode1441.buildArray(new int[]{1, 3}, 3));
        System.out.println(leetCode1441.buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(leetCode1441.buildArray(new int[]{1, 2}, 4));
        System.out.println(leetCode1441.buildArray(new int[]{2, 3, 4}, 4));
    }
}
