package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode779 {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (k == 1) {
            return 0;
        }
        if (k == 2) {
            return 1;
        }
        if (k % 2 == 0) {
            return kthGrammar(n - 1, k / 2) ^ 1;
        }
        return kthGrammar(n - 1, k / 2 + 1);
    }

    @Test
    public void testCase1() {
        LeetCode779 leetCode779 = new LeetCode779();
        assert leetCode779.kthGrammar(1, 1) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode779 leetCode779 = new LeetCode779();
        assert leetCode779.kthGrammar(2, 1) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode779 leetCode779 = new LeetCode779();
        assert leetCode779.kthGrammar(2, 2) == 1;
    }

    @Test
    public void testCase4() {
        LeetCode779 leetCode779 = new LeetCode779();
        assert leetCode779.kthGrammar(4, 5) == 1;
    }

    @Test
    public void testCase5() {
        LeetCode779 leetCode779 = new LeetCode779();
        assert leetCode779.kthGrammar(3, 1) == 0;
    }

    @Test
    public void testCase6() {
        LeetCode779 leetCode779 = new LeetCode779();
        assert leetCode779.kthGrammar(3, 3) == 1;
    }
}
