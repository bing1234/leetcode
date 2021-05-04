package com.geekbing;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
//        (5820051212^1234567890987654321)%5820210412=
        System.out.println(remainder(5820051212L, 1234567890987654321L, 5820210412L));
    }

    public static long remainder(long a, long b, long p) {
        if (b == 0) {
            return 1;
        } else if (b % 2 == 1) {
            //奇数
            return a * remainder(a, b - 1, p) % p;
        } else {
            // 偶数
            long tmp = remainder(a, b / 2, p) % p;
            return (tmp * tmp) % p;
        }
    }

//    public static long remainder(long x, long n, long p) {
//        long res = 1L;
//        for (int i = 0; i < n; i++) {
//            res = (res * x) % p;
//        }
//        return res;
//    }

    //非递归写法，位运算思想

    /**
     * 将b写成二进制，如2^13=2^8*2^4*2^1,13=1101
     * 循环判断b末尾是否是1，是1,res*=b
     * a=a*a，b右移一位
     * 直到b<=0
     **/
//    public static long remainder(long a, long b, long p) {
//        long res = 1;
//        while (b > 0) {
//            if (b % 2 == 1) {
//                //or b%2==1
//                res = (res * a) % p;
//            }
//            a = (a * a) % p;
//            b >>= 1;
//        }
//        return res;
//    }
}
