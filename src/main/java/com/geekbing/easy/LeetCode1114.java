package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 * @author bing
 */
public class LeetCode1114 {
    class Foo {
        private Semaphore semaphore2, semaphore3;

        public Foo() {
            semaphore2 = new Semaphore(0);
            semaphore3 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            semaphore2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore2.acquire();
            printSecond.run();
            semaphore3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore3.acquire();
            printThird.run();
        }
    }

    private static class PrintFirst implements Runnable {
        @Override
        public void run() {
            System.out.println("first");
        }
    }

    private static class PrintSecond implements Runnable {
        @Override
        public void run() {
            System.out.println("second");
        }
    }

    private static class PrintThird implements Runnable {
        @Override
        public void run() {
            System.out.println("third");
        }
    }

    @Test
    public void testCase1() {
        Foo foo = new Foo();

        PrintFirst printFirst = new PrintFirst();
        PrintSecond printSecond = new PrintSecond();
        PrintThird printThird = new PrintThird();

        Thread A = new Thread(() -> {
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        B.start();
        A.start();
        C.start();
    }

    @Test
    public void testCase2() throws InterruptedException {
        Foo foo = new Foo();

        PrintFirst printFirst = new PrintFirst();
        PrintSecond printSecond = new PrintSecond();
        PrintThird printThird = new PrintThird();

        Thread A = new Thread(() -> {
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        A.start();
        B.start();
        C.start();
    }
}
