package com.sterefine.energetic.standalone;

/**
 * @author: sterefine
 * Test debug
 * breakpoint
 * suspend * All * Thread check
 * 2020/8/16
 */
public class ThreadBreakApplication {
    public static void main(String[] args) {
        Thread t1 = new ThreadTester("Thread-1");
        t1.start();
        Thread t2 = new ThreadTester("Thread-2");
        t2.start();
        System.out.println("All thread end");
    }
}

class ThreadTester extends Thread {
    public ThreadTester(String name) {
        this.setName(name);
    }

    @Override
    public void run(){
        System.out.println(this.getName() + " start");
        System.out.println(this.getName() + " end");
    }
}
