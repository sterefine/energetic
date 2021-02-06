package com.sterefine.energetic.standalone;

import lombok.SneakyThrows;

/**
 * @author: sterefine
 * Test Share Thread data
 */
public class ThreadShareDataApplication {
    @SneakyThrows
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();

        Thread t1 = new Thread(()-> {
                    stringBuffer.append("1");
                },
                "1");

        Thread t2 = new Thread(()-> {
                    stringBuffer.append("2");
                    try {
                        t1.join();
                    } catch(Exception e) {

                    }
                },
                "2");

        Thread t3 = new Thread(()-> {
            stringBuffer.append("3");
            try {
               t2.join();
            } catch(Exception e) {

            }
        }, "3");

        t1.start();
        t2.start();
        t3.start();
        t3.join();
        System.out.println(stringBuffer.toString());

    }
}

