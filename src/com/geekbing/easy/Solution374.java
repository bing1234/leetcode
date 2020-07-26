package com.geekbing.easy;

/**
 * @author bing
 */
public class Solution374 {
    private Integer pick = 6;

    public void setPick(Integer pick) {
        this.pick = pick;
    }

    public int guessNumber(int n) {
        int low = 1, high = n, middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            int flag = guess(middle);
            if (flag == -1) {
                high = middle - 1;
            } else if (flag == 0) {
                return middle;
            } else {
                low = middle + 1;
            }
        }
        return 0;
    }

    private int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num == pick) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Solution374 solution374 = new Solution374();
        solution374.setPick(6);
        System.out.println(solution374.guessNumber(10));
    }
}
