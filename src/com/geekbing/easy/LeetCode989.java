package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int carry = 0, indexA = A.length - 1, currentA, currentK;
        while (true) {
            if (indexA < 0 && K == 0) {
                break;
            }
            currentA = indexA < 0 ? 0 : A[indexA];
            currentK = K == 0 ? 0 : K % 10;
            int current = currentA + currentK % 10 + carry;
            if (current >= 10) {
                carry = 1;
                result.add(0, current - 10);
            } else {
                carry = 0;
                result.add(0, current);
            }
            indexA--;
            K = K / 10;
        }
        if (carry == 1) {
            result.add(0, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode989 leetCode989 = new LeetCode989();
        System.out.println(leetCode989.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(leetCode989.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(leetCode989.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(leetCode989.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }
}
