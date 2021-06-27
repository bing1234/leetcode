package com.geekbing.offer;

/**
 * @author bing
 */
public class Offer3 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] *= -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Offer3 offer3 = new Offer3();

        System.out.println(offer3.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
