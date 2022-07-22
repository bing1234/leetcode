package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author bing
 */
public class LeetCode670 {
    public int maximumSwap(int num) {
        int numCopy = num;
        int[] arr = new int[String.valueOf(numCopy).length()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = numCopy % 10;
            numCopy /= 10;
        }

        int[] sort = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        // 找到第一个不相等的
        int idx1 = -1, idx2 = -1, needChange = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sort[i]) {
                idx1 = i;
                needChange = sort[i];
                break;
            }
        }
        if (idx1 == -1) {
            return num;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == needChange) {
                idx2 = i;
                break;
            }
        }
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        int ans = 0;
        for (int item : arr) {
            ans = ans * 10 + item;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode670 leetCode670 = new LeetCode670();
        assert leetCode670.maximumSwap(2736) == 7236;
    }

    @Test
    public void testCase2() {
        LeetCode670 leetCode670 = new LeetCode670();
        assert leetCode670.maximumSwap(9973) == 9973;
    }

    @Test
    public void testCase3() {
        LeetCode670 leetCode670 = new LeetCode670();
        assert leetCode670.maximumSwap(98368) == 98863;
    }
}
