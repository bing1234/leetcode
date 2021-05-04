package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 所有元素的和
        int sum = 0;
        // 和 - 下标数组
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            List<Integer> idxs = map.get(sum);
            if (idxs == null) {
                idxs = new ArrayList<>();
            }
            idxs.add(i);
            map.put(sum, idxs);
        }
        // 不能被3整除则不行
        if (sum % 3 != 0) {
            return false;
        }
        int subSum = sum / 3;
        if (!map.containsKey(subSum)) {
            return false;
        }
        List<Integer> idxs = map.get(subSum);
        for (Integer idx : idxs) {
            if (canTwoPartsEqualSum(arr, idx + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean canTwoPartsEqualSum(int[] arr, int beginIdx) {
        if (arr == null || arr.length == 0 || beginIdx >= arr.length - 1) {
            return false;
        }
        int total = 0;
        for (int i = beginIdx; i < arr.length; i++) {
            total += arr[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        int sub = total / 2;

        int subSum = 0;
        for (int i = beginIdx; i < arr.length - 1; i++) {
            subSum += arr[i];
            if (subSum == sub) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1013 leetCode1013 = new LeetCode1013();
//        System.out.println(leetCode1013.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
//        System.out.println(leetCode1013.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
//        System.out.println(leetCode1013.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(leetCode1013.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));

    }
}
