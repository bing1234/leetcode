package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0, temp;
        int indexA = a.length() - 1, indexB = b.length() - 1;
        char currentA, currentB;
        while (indexA >= 0 || indexB >= 0) {
            // 不足的用0替代
            currentA = indexA >= 0 ? a.charAt(indexA) : '0';
            currentB = indexB >= 0 ? b.charAt(indexB) : '0';
            temp = currentA + currentB + carry - 96;
            carry = temp < 2 ? 0 : 1;
            if (temp == 0 || temp == 2) {
                result.insert(0, "0");
            } else {
                result.insert(0, "1");
            }
            indexA--;
            indexB--;
        }
        return carry == 1 ? "1" + result : result.toString();
    }

    public static void main(String[] args) {
        LeetCode67 leetCode67 = new LeetCode67();
        System.out.println(leetCode67.addBinary("11", "1"));
        System.out.println(leetCode67.addBinary("1010", "1011"));
    }
}
