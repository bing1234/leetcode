package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode1442 {
    public int countTriplets(int[] arr) {
        int ans = 0, xor;
        for (int i = 0; i < arr.length - 1; i++) {
            xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if (xor == 0) {
                    ans += j - i;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LeetCode1442 leetCode1442 = new LeetCode1442();

        System.out.println(leetCode1442.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(leetCode1442.countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(leetCode1442.countTriplets(new int[]{2, 3}));
        System.out.println(leetCode1442.countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(leetCode1442.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }
}
