package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode592 {
    public String fractionAddition(String expression) {
        // 得到所有的分子和分母
        List<Express> items = parseExpression(expression);
        // 得到新的分母，即所有分母的最小公倍数
        int minCommonBase = calMinCommonBases(items);
        // 得到新的分子
        int newDividend = calExpress(items, minCommonBase);
        // 得到新的分子和分母的最大公约数
        int gcd = gcd(Math.abs(newDividend), minCommonBase);
        // 返回结果
        return newDividend / gcd + "/" + minCommonBase / gcd;
    }

    private List<Express> parseExpression(String expression) {
        List<Express> ans = new ArrayList<>();
        int idx = 0, dividend = 0;
        boolean add = true;
        while (idx < expression.length()) {
            char c = expression.charAt(idx);
            switch (c) {
                case '+':
                    add = true;
                    idx++;
                    break;
                case '-':
                    add = false;
                    idx++;
                    break;
                case '/':
                    add = true;
                    idx++;
                    break;
                default:
                    // 当前是数字
                    int num = 0;
                    while (idx < expression.length() && '0' <= expression.charAt(idx) && expression.charAt(idx) <= '9') {
                        num = num * 10 + expression.charAt(idx) - '0';
                        idx++;
                    }
                    // 当前数字是分子
                    if (idx < expression.length() && expression.charAt(idx) == '/') {
                        dividend = add ? num : -num;
                    } else {
                        ans.add(new Express(dividend, add ? num : -num));
                    }
                    add = true;
                    break;
            }
        }
        return ans;
    }

    private int calMinCommonBases(List<Express> items) {
        int temp = items.get(0).divisor;
        for (int i = 1; i < items.size(); i++) {
            temp = calMinCommonBase(temp, items.get(i).divisor);
        }
        return temp;
    }

    private int calMinCommonBase(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int calExpress(List<Express> expresses, int minCommonBase) {
        int ans = 0;
        for (Express express : expresses) {
            ans += express.dividend * (minCommonBase / express.divisor);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    private static class Express {
        /**
         * 分子
         */
        private int dividend;

        /**
         * 分母
         */
        private int divisor;

        public Express(int dividend, int divisor) {
            this.dividend = dividend;
            this.divisor = divisor;
        }
    }

    @Test
    public void testCase1() {
        LeetCode592 leetCode592 = new LeetCode592();
        assert leetCode592.fractionAddition("-1/2+1/2").equals("0/1");
    }

    @Test
    public void testCase2() {
        LeetCode592 leetCode592 = new LeetCode592();
        assert leetCode592.fractionAddition("-1/2+1/2+1/3").equals("1/3");
    }

    @Test
    public void testCase3() {
        LeetCode592 leetCode592 = new LeetCode592();
        assert leetCode592.fractionAddition("1/3-1/2").equals("-1/6");
    }
}
