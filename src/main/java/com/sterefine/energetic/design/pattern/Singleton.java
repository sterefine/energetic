package com.sterefine.energetic.design.pattern;

/**
 * @author: doudai
 * 2020/9/7
 */
public class Singleton {

    private Singleton(){}

    private static Singleton instance = null ;

    public static Singleton getInstance(){
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
