package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        return new String[]{};
    }

    public static void main(String[] args) {
        LeetCode599 leetCode599 = new LeetCode599();
        System.out.println(Arrays.toString(leetCode599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(leetCode599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"})));
    }
}
