package com.geekbing.easy;

public class LeetCode944 {
    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode944 leetCode944 = new LeetCode944();
        System.out.println(leetCode944.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(leetCode944.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(leetCode944.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        System.out.println(leetCode944.minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));
    }
}
