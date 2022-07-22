package com.geekbing.offer;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class OfferII009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0, right = 0, ans = 0, product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        OfferII009 offerII009 = new OfferII009();
        assert offerII009.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100) == 8;
    }

    @Test
    public void testCase2() {
        OfferII009 offerII009 = new OfferII009();
        assert offerII009.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0) == 0;
    }
}
