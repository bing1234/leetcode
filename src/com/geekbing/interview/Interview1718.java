package com.geekbing.interview;

import java.util.Arrays;

public class Interview1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        if (big.length < small.length) {
            return new int[]{};
        }
        int[] closure = getClosures(big, small);
        return getShortestClosure(closure);
    }

    /**
     * 获取每个索引的终结位置
     */
    private int[] getClosures(int[] big, int[] small) {
        int[] closure = new int[big.length];
        for (int num : small) {
            sweepForClosure(big, closure, num);
        }
        return closure;
    }

    private void sweepForClosure(int[] big, int[] closure, int num) {
        int idx = -1;
        for (int i = big.length - 1; i >= 0; i--) {
            if (big[i] == num) {
                idx = i;
            }
            if (closure[i] != -1 && (closure[i] < idx || idx == -1)) {
                closure[i] = idx;
            }
        }
    }

    private int[] getShortestClosure(int[] closure) {
        int[] ans = new int[]{};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < closure.length; i++) {
            if (closure[i] == -1) {
                continue;
            }
            if (min > closure[i] - i) {
                min = closure[i] - i;
                ans = new int[]{i, closure[i]};
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Interview1718 interview1718 = new Interview1718();
        System.out.println(Arrays.toString(interview1718.shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9})));
        System.out.println(Arrays.toString(interview1718.shortestSeq(new int[]{1, 2, 3}, new int[]{4})));
    }
}
