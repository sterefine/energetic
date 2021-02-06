package com.sterefine.energetic.standalone;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: sterefine
 * Test Share Thread data
 */
public class ThreadShareData2Application {
    @SneakyThrows
    public static void main(String[] args) {
        useThread();
        usePool();
    }

    @SneakyThrows
    private static void useThread() {
        StringBuffer stringBuffer = new StringBuffer();
        Thread t1 = new Thread(new myRunnable(stringBuffer));
        Thread t2 = new Thread(new myRunnable(stringBuffer));
        Thread t3 = new Thread(new myRunnable(stringBuffer));
        Thread t4 = new Thread(new myRunnable(stringBuffer));
        new Thread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();;
        t4.join();;
        System.out.println(stringBuffer);
    }

    private static void usePool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i< 4; i++ ) {
            executorService.submit(new myRunnable(stringBuffer));
        }
        executorService.shutdown();
        System.out.println(stringBuffer);
    }

    @AllArgsConstructor
    private static class myRunnable implements Runnable {
        private StringBuffer sb;

        @Override
        public void run(){
            appendNew();
        }

        private void appendNew() {
            synchronized (sb) {
                sb.insert(sb.length(), sb.length() + 1);
            }
        }
    }
}



