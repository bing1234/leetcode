package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author bing
 */
public class LeetCode1195 {
    private static class FizzBuzz {
        private int n;
        private final Semaphore semaphoreFizz, semaphoreBuzz, semaphoreFizzBuzz, semaphoreNum;

        public FizzBuzz(int n) {
            this.n = n;
            this.semaphoreNum = new Semaphore(1);
            this.semaphoreFizz = new Semaphore(0);
            this.semaphoreBuzz = new Semaphore(0);
            this.semaphoreFizzBuzz = new Semaphore(0);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    semaphoreFizz.acquire();
                    printFizz.run();
                    releaseSemaphore(i + 1);
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    semaphoreBuzz.acquire();
                    printBuzz.run();
                    releaseSemaphore(i + 1);
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    semaphoreFizzBuzz.acquire();
                    printFizzBuzz.run();
                    semaphoreNum.release();
                    releaseSemaphore(i + 1);
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 != 0) {
                    semaphoreNum.acquire();
                    printNumber.accept(i);
                    releaseSemaphore(i + 1);
                }
            }
        }

        private void releaseSemaphore(int i) {
            if (i > n) {
                return;
            }
            if (i % 3 == 0 && i % 5 == 0) {
                semaphoreFizzBuzz.release();
            } else if (i % 3 == 0) {
                semaphoreFizz.release();
            } else if (i % 5 == 0) {
                semaphoreBuzz.release();
            } else {
                semaphoreNum.release();
            }
        }
    }

    @Test
    public void testCase1() {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread numberThread = new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();
    }
}
