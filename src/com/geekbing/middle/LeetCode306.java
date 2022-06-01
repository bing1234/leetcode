package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode306 {
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> temp = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        dfs(num, 0);
        return !ans.isEmpty();
    }

    private void dfs(String num, int begin) {
        if (begin == num.length()) {
            if (temp.size() < 3) {
                return;
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int len = 1; len <= num.length(); len++) {
            // 保证能正常的截取字符串num.substring(begin, begin + len);
            if (begin + len - 1 >= num.length()) {
                return;
            }
            // 去除前导0的情况
            if (len > 1 && num.charAt(begin) == '0') {
                return;
            }
            // 切割字符串
            String cur = num.substring(begin, begin + len);
            if (temp.size() >= 2) {
                int res = compareThreeNum(temp.get(temp.size() - 2), temp.get(temp.size() - 1), cur);
                if (res == -1) {
                    return;
                } else if (res == 0) {
                    temp.add(cur);
                    dfs(num, begin + len);
                    temp.remove(temp.size() - 1);
                }
            } else {
                temp.add(cur);
                dfs(num, begin + len);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private int compareThreeNum(String num1, String num2, String num3) {
        BigInteger big1 = new BigInteger(num1);
        BigInteger big2 = new BigInteger(num2);
        BigInteger big3 = new BigInteger(num3);
        return big1.add(big2).compareTo(big3);
    }

    @Test
    public void testCase1() {
        LeetCode306 leetCode306 = new LeetCode306();
        assert leetCode306.isAdditiveNumber("112358");
    }

    @Test
    public void testCase2() {
        LeetCode306 leetCode306 = new LeetCode306();
        assert leetCode306.isAdditiveNumber("199100199");
    }

    @Test
    public void testCase3() {
        LeetCode306 leetCode306 = new LeetCode306();
        assert leetCode306.isAdditiveNumber("123");
    }

    @Test
    public void testCase4() {
        LeetCode306 leetCode306 = new LeetCode306();
        assert !leetCode306.isAdditiveNumber("124");
    }

    @Test
    public void testCase5() {
        LeetCode306 leetCode306 = new LeetCode306();
        assert !leetCode306.isAdditiveNumber("121");
    }
}
