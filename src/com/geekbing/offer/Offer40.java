package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author bing
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!queue.isEmpty() && queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            if (!queue.isEmpty()) {
                ans[i] = queue.poll();
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        Offer40 offer40 = new Offer40();
        int[] ans = offer40.getLeastNumbers(new int[]{3, 2, 1}, 2);
        int[] expert = new int[]{1, 2};
        ans = Arrays.stream(ans).sorted().toArray();
        expert = Arrays.stream(expert).sorted().toArray();
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        Offer40 offer40 = new Offer40();
        int[] ans = offer40.getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
        int[] expert = new int[]{0};
        ans = Arrays.stream(ans).sorted().toArray();
        expert = Arrays.stream(expert).sorted().toArray();
        assert Arrays.equals(expert, ans);
    }
}
