package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2062 {
    public int countVowelSubstrings(String word) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode2062 leetCode2062 = new LeetCode2062();
        assert leetCode2062.countVowelSubstrings("aeiouu") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2062 leetCode2062 = new LeetCode2062();
        assert leetCode2062.countVowelSubstrings("unicornarihan") == 0;
    }

    @Test
    public void testCase3() {
        LeetCode2062 leetCode2062 = new LeetCode2062();
        assert leetCode2062.countVowelSubstrings("cuaieuouac") == 7;
    }

    @Test
    public void testCase4() {
        LeetCode2062 leetCode2062 = new LeetCode2062();
        assert leetCode2062.countVowelSubstrings("bbaeixoubb") == 0;
    }
}
