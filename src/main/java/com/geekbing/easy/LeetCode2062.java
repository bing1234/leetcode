package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * 思路：
 * 将字符串使用非元音字符进行切分，得到每段只包含元音字符的子串
 * 然后将每段只包含元音字符的子串求解元音子字符串的数量
 * 最后求和即可
 *
 * @author bing
 */
public class LeetCode2062 {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        char[] chars = word.toCharArray();
        int len = chars.length, i = 0;
        while (i < len) {
            // 找到第一个元音字母
            while (i < len && !isVowel(chars[i])) {
                i++;
            }
            int left = i;

            // 找到连续元音字母的右边界
            while (i < len && isVowel(chars[i])) {
                i++;
            }
            int right = i;

            if (right - left >= 5) {
                ans += countVowelSub(word.substring(left, right));
            }
        }
        return ans;
    }

    private int countVowelSub(String str) {
        char[] chars = str.toCharArray();
        int[] bucket = new int[26];
        int ans = 0;
        // 左、右指针，对每个左指针，找到最小的右指针是的[left, right]为最小元音字符的子串
        int left = 0, right = 0, len = chars.length;
        while (right < str.length()) {
            bucket[chars[right] - 'a']++;
            if (containAll(bucket)) {
                ans += len - right;

                // 收缩左指针
                bucket[chars[left] - 'a']--;
                left++;
                while (containAll(bucket)) {
                    ans += len - right;
                    bucket[chars[left] - 'a']--;
                    left++;
                }
            }
            right++;
        }
        while (left < str.length()) {
            if (containAll(bucket)) {
                ans++;
                left++;
            } else {
                break;
            }
        }
        return ans;
    }

    private boolean containAll(int[] bucket) {
        return bucket[0] > 0 && bucket['e' - 'a'] > 0 && bucket['i' - 'a'] > 0 && bucket['o' - 'a'] > 0 && bucket['u' - 'a'] > 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
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

    @Test
    public void testCase5() {
        LeetCode2062 leetCode2062 = new LeetCode2062();
        assert leetCode2062.countVowelSubstrings("caaaeiouaacaaaeiouaac") == 22;
    }
}
