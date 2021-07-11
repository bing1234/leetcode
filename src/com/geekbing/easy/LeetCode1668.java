package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1668 {
    public int maxRepeating(String sequence, String word) {
        if (sequence.length() < word.length()) {
            return 0;
        }

        // 找到所有重复的开始起点
        int ans = 0;
        for (int i = 0; i <= sequence.length() - word.length(); i++) {
            // 获取重复的次数
            int times = repeatTimes(sequence, word, i);
            ans = Math.max(ans, times);
        }
        return ans;
    }

    private int repeatTimes(String sequence, String word, int begin) {
        int times = 0;
        for (int i = begin; i <= sequence.length() - word.length(); i += word.length()) {
            if (!repeat(sequence, word, i)) {
                break;
            }
            times++;
        }
        return times;
    }

    private boolean repeat(String sequence, String word, int begin) {
        int idx = begin;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != sequence.charAt(idx)) {
                return false;
            }
            idx++;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1668 leetCode1668 = new LeetCode1668();

//        System.out.println(leetCode1668.maxRepeating("ababc", "ab"));
//        System.out.println(leetCode1668.maxRepeating("ababc", "ba"));
//        System.out.println(leetCode1668.maxRepeating("ababc", "ac"));
//        System.out.println(leetCode1668.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
//        System.out.println(leetCode1668.maxRepeating("a", "a"));
        System.out.println(leetCode1668.maxRepeating("baaba", "ab"));
    }
}
