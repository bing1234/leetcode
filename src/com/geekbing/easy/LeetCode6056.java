package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode6056 {
    public String largestGoodInteger(String num) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        while (i < num.length()) {
            int j = i;
            while (j + 1 < num.length() && num.charAt(j) == num.charAt(j + 1)) {
                j++;
            }
            if (j - i + 1 >= 3) {
                set.add(num.charAt(i));
            }
            if (i == j) {
                i++;
            } else {
                i = j;
            }
        }
        if (set.size() == 0) {
            return "";
        }
        List<Character> list = set.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        return "" + list.get(0) + list.get(0) + list.get(0);
    }

    @Test
    public void testCase1() {
        LeetCode6056 leetCode6056 = new LeetCode6056();
        assert leetCode6056.largestGoodInteger("6777133339").equals("777");
    }

    @Test
    public void testCase2() {
        LeetCode6056 leetCode6056 = new LeetCode6056();
        assert leetCode6056.largestGoodInteger("2300019").equals("000");
    }

    @Test
    public void testCase3() {
        LeetCode6056 leetCode6056 = new LeetCode6056();
        assert leetCode6056.largestGoodInteger("42352338").equals("");
    }

    @Test
    public void testCase4() {
        LeetCode6056 leetCode6056 = new LeetCode6056();
        assert leetCode6056.largestGoodInteger("74444").equals("444");
    }
}
