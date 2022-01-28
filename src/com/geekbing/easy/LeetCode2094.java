package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode2094 {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 == 0) {
                indexes.add(i);
            }
        }
        Set<Integer> ans = new HashSet<>();
        for (Integer index : indexes) {
            for (int i = 0; i < digits.length; i++) {
                for (int j = 0; j < digits.length; j++) {
                    if (i != j && i != index && j != index) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[index];
                        if (num >= 100) {
                            ans.add(num);
                        }
                    }
                }
            }
        }
        return ans.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testCase1() {
        LeetCode2094 leetCode2094 = new LeetCode2094();
        int[] ans = leetCode2094.findEvenNumbers(new int[]{2, 1, 3, 0});
        int[] expert = new int[]{102, 120, 130, 132, 210, 230, 302, 310, 312, 320};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2094 leetCode2094 = new LeetCode2094();
        int[] ans = leetCode2094.findEvenNumbers(new int[]{2, 2, 8, 8, 2});
        int[] expert = new int[]{222, 228, 282, 288, 822, 828, 882};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode2094 leetCode2094 = new LeetCode2094();
        int[] ans = leetCode2094.findEvenNumbers(new int[]{3, 7, 5});
        assert Arrays.equals(ans, new int[]{});
    }

    @Test
    public void testCase4() {
        LeetCode2094 leetCode2094 = new LeetCode2094();
        int[] ans = leetCode2094.findEvenNumbers(new int[]{0, 2, 0, 0});
        assert Arrays.equals(ans, new int[]{200});
    }

    @Test
    public void testCase5() {
        LeetCode2094 leetCode2094 = new LeetCode2094();
        int[] ans = leetCode2094.findEvenNumbers(new int[]{0, 0, 0});
        assert Arrays.equals(ans, new int[]{});
    }
}
