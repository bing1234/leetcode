package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1592 {
    public String reorderSpaces(String text) {
        // 空格的数量
        int blankCount = 0;
        // 所有的单词
        List<String> words = new ArrayList<>();

        char[] chars = text.toCharArray();
        String curWord = "";
        for (char c : chars) {
            if (c == ' ') {
                blankCount++;
                if (!"".equals(curWord)) {
                    words.add(curWord);
                    curWord = "";
                }
            } else {
                curWord += c;
            }
        }
        if (!"".equals(curWord)) {
            words.add(curWord);
        }

        // 特殊情况处理
        if (words.size() == 1) {
            return words.get(0) + geneBlank(blankCount);
        }

        // 单词间的间隙
        int gap = blankCount / (words.size() - 1);
        // 结尾剩余的空格
        int remainer = blankCount - gap * (words.size() - 1);

        // 生成单词间的间隙，由空格组成
        String gapBlank = geneBlank(gap);

        // 拼接结果
        StringBuilder ans = new StringBuilder(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            ans.append(gapBlank).append(words.get(i));
        }
        ans.append(geneBlank(remainer));
        return ans.toString();
    }

    private String geneBlank(int n) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append(" ");
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode1592 leetCode1592 = new LeetCode1592();
        assert "this   is   a   sentence".equals(leetCode1592.reorderSpaces("  this   is  a sentence "));
    }

    @Test
    public void testCase2() {
        LeetCode1592 leetCode1592 = new LeetCode1592();
        assert "practice   makes   perfect ".equals(leetCode1592.reorderSpaces(" practice   makes   perfect"));
    }

    @Test
    public void testCase3() {
        LeetCode1592 leetCode1592 = new LeetCode1592();
        assert "hello   world".equals(leetCode1592.reorderSpaces("hello   world"));
    }

    @Test
    public void testCase4() {
        LeetCode1592 leetCode1592 = new LeetCode1592();
        assert "walks  udp  package  into  bar  a ".equals(leetCode1592.reorderSpaces("  walks  udp package   into  bar a"));
    }

    @Test
    public void testCase5() {
        LeetCode1592 leetCode1592 = new LeetCode1592();
        assert "a".equals(leetCode1592.reorderSpaces("a"));
    }
}
