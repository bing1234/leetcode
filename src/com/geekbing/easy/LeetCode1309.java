package com.geekbing.easy;

public class LeetCode1309 {
    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                ans.append((char) (Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1)) + 96));
                i = i + 2;
            } else {
                ans.append((char) (s.charAt(i) + 48));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode1309 leetCode1309 = new LeetCode1309();
        System.out.println(leetCode1309.freqAlphabets("10#11#12"));
        System.out.println(leetCode1309.freqAlphabets("1326#"));
        System.out.println(leetCode1309.freqAlphabets("25#"));
        System.out.println(leetCode1309.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
