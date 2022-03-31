package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 * @author bing
 */
public class LeetCode1115 {
    private static class FooBar {
        private final Semaphore semaphore1;
        private final Semaphore semaphore2;
        private final int n;

        public FooBar(int n) {
            this.n = n;
            semaphore1 = new Semaphore(1);
            semaphore2 = new Semaphore(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                semaphore1.acquire();
                printFoo.run();
                semaphore2.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                semaphore2.acquire();
                printBar.run();
                semaphore1.release();
            }
        }
    }

    @Test
    public void testCase1() throws InterruptedException {
        FooBar fooBar = new FooBar(1);
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();
    }

    @Test
    public void testCase2() throws InterruptedException {
        FooBar fooBar = new FooBar(2);
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();
    }
}
