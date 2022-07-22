package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1352 {
    private static class ProductOfNumbers {
        /**
         * preProd[i]表示前i个数的乘积
         */
        private List<Integer> preProd;

        public ProductOfNumbers() {
            preProd = new ArrayList<>();
            preProd.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                preProd = new ArrayList<>();
                preProd.add(1);
            } else {
                preProd.add(num * preProd.get(preProd.size() - 1));
            }
        }

        public int getProduct(int k) {
            if (preProd.size() <= k) {
                return 0;
            }
            return preProd.get(preProd.size() - 1) / preProd.get(preProd.size() - 1 - k);
        }
    }

    @Test
    public void testCase1() {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        assert productOfNumbers.getProduct(2) == 20; // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        assert productOfNumbers.getProduct(3) == 40; // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        assert productOfNumbers.getProduct(4) == 0; // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        assert productOfNumbers.getProduct(2) == 32; // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
    }
}
