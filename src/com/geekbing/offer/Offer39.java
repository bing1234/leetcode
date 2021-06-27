package com.geekbing.offer;

/**
 * @author bing
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int left = 0, leftCnt = 0;
        for (int num : nums) {
            if (leftCnt == 0) {
                left = num;
                leftCnt = 1;
            } else {
                if (num == left) {
                    leftCnt++;
                } else {
                    leftCnt--;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Offer39 offer39 = new Offer39();

        System.out.println(offer39.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
