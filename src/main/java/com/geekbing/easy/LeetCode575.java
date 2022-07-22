package com.geekbing.easy;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = Arrays.stream(candies).boxed().collect(Collectors.toSet());
        return Math.min(kinds.size(), candies.length / 2);
    }

    public static void main(String[] args) {
        LeetCode575 leetCode575 = new LeetCode575();
        System.out.println(leetCode575.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(leetCode575.distributeCandies(new int[]{1, 1, 2, 3}));
    }
}
