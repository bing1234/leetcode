package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author bing
 */
public class LeetCode1116 {
    private static class ZeroEvenOdd {
        private final Semaphore zeroSemaphore, evenSemaphore, oddSemaphore;
        private int n;

        public ZeroEvenOdd(int n) {
            zeroSemaphore = new Semaphore(1);
            evenSemaphore = new Semaphore(0);
            oddSemaphore = new Semaphore(0);
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zeroSemaphore.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    evenSemaphore.release();
                } else {
                    oddSemaphore.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    evenSemaphore.acquire();
                    printNumber.accept(i);
                    zeroSemaphore.release();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) {
                    oddSemaphore.acquire();
                    printNumber.accept(i);
                    zeroSemaphore.release();
                }
            }
        }
    }

    @Test
    public void testCase1() throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        zeroThread.start();
        oddThread.start();
        evenThread.start();
    }

    @Test
    public void testCase2() throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        oddThread.start();
        zeroThread.start();
        evenThread.start();
    }
}
