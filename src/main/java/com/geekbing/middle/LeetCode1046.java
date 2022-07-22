package com.geekbing.middle;

public class LeetCode1046 {
    public int lastStoneWeight(int[] stones) {
        while (true) {
            int[] index = findMaxTwo(stones);
            if (index[0] == -1 || index[1] == -1) {
                break;
            }
            stones[index[0]] = stones[index[0]] - stones[index[1]];
            stones[index[1]] = 0;
        }
        for (int stone : stones) {
            if (stone != 0) {
                return stone;
            }
        }
        return 0;
    }

    private int[] findMaxTwo(int[] stones) {
        int max = -1;
        int maxIndex = -1;
        int second = -1;
        int secondIndex = -1;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == 0) {
                continue;
            }
            if (second < stones[i] && stones[i] <= max) {
                second = stones[i];
                secondIndex = i;
            } else if (max < stones[i]) {
                second = max;
                secondIndex = maxIndex;
                max = stones[i];
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, secondIndex};
    }

    public static void main(String[] args) {
        LeetCode1046 leetCode1046 = new LeetCode1046();
        System.out.println(leetCode1046.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
