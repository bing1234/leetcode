package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 * @author bing
 */
public class LeetCode1117 {
    private static class H2O {
        private final Semaphore semaphoreH, semaphoreO;

        public H2O() {
            semaphoreH = new Semaphore(2);
            semaphoreO = new Semaphore(0);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            semaphoreH.acquire();
            releaseHydrogen.run();
            semaphoreO.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            semaphoreO.acquire(2);
            releaseOxygen.run();
            semaphoreH.release(2);
        }
    }

    @Test
    public void testCase1() {
        H2O h2o = new H2O();
        Thread hydrogenThread = new Thread(() -> {
            try {
                h2o.hydrogen(() -> System.out.println("H"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread oxygenThread = new Thread(() -> {
            try {
                h2o.oxygen(() -> System.out.println("o"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        hydrogenThread.start();
        oxygenThread.start();
    }
}
