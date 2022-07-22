package com.geekbing.offer;

public class Offer64 {
    public int sumNums(int n) {
        boolean flag = n > 1 && (n = n + sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Offer64 offer64 = new Offer64();
        System.out.println(offer64.sumNums(3));
        System.out.println(offer64.sumNums(9));
    }
}
