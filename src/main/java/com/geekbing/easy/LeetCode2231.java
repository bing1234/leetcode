package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2231 {
    public int largestInteger(int num) {
        // 奇数、偶数、每一位的奇偶性(0表示偶数,1表示奇数)
        List<Integer> odds = new ArrayList<>(), evens = new ArrayList<>(), oddEvens = new ArrayList<>();
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i) - '0';
            if (cur % 2 == 0) {
                evens.add(cur);
                oddEvens.add(0);
            } else {
                odds.add(cur);
                oddEvens.add(1);
            }
        }
        // 倒叙
        odds = odds.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        evens = evens.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int ans = 0, oddIdx = 0, evenIdx = 0;
        for (Integer oddEven : oddEvens) {
            if (oddEven == 0) {
                ans = ans * 10 + evens.get(oddIdx++);
            } else {
                ans = ans * 10 + odds.get(evenIdx++);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2231 leetCode2231 = new LeetCode2231();
        assert leetCode2231.largestInteger(1234) == 3412;
    }

    @Test
    public void testCase2() {
        LeetCode2231 leetCode2231 = new LeetCode2231();
        assert leetCode2231.largestInteger(65875) == 87655;
    }
}
