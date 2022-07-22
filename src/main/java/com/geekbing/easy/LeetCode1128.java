package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<Tuple, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            Tuple tuple = new Tuple(Math.min(dominoe[0], dominoe[1]), Math.max(dominoe[0], dominoe[1]));
            map.merge(tuple, 1, Integer::sum);
        }
        for (int num : map.values()) {
            count += (num - 1) * num / 2;
        }
        return count;
    }

    private static final class Tuple {
        private Integer a;
        private Integer b;

        @Override
        public int hashCode() {
            int result = 17;
            result = 37 * result + a;
            result = 37 * result + b;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Tuple)) {
                return false;
            }
            Tuple tuple = (Tuple) obj;
            return tuple.getA().equals(a) && tuple.getB().equals(b);
        }

        public Tuple(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }
    }

    public static void main(String[] args) {
        LeetCode1128 leetCode1128 = new LeetCode1128();
        System.out.println(leetCode1128.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
    }
}
