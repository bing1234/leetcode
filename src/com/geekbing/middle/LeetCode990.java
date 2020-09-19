package com.geekbing.middle;

/**
 * todo
 */
public class LeetCode990 {
    public boolean equationsPossible(String[] equations) {
        return false;
    }

    public static void main(String[] args) {
        LeetCode990 leetCode990 = new LeetCode990();
        System.out.println(leetCode990.equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(leetCode990.equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(leetCode990.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(leetCode990.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(leetCode990.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }
}
