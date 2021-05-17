package com.geekbing.easy;

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

    public static void main(String[] args) {
        LeetCode1592 leetCode1592 = new LeetCode1592();
        System.out.println(leetCode1592.reorderSpaces("  this   is  a sentence "));
        System.out.println(leetCode1592.reorderSpaces(" practice   makes   perfect"));
        System.out.println(leetCode1592.reorderSpaces("hello   world"));
        System.out.println(leetCode1592.reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(leetCode1592.reorderSpaces("a"));
        System.out.println(leetCode1592.reorderSpaces("a "));
        System.out.println(leetCode1592.reorderSpaces(" a"));
        System.out.println(leetCode1592.reorderSpaces(" a "));
    }
}
