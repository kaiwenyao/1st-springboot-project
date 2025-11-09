package com.itheima;

import io.jsonwebtoken.Claims;

public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {

        local.set("Main message");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": " + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + ": " + local.get());

        local.remove();
        System.out.println(Thread.currentThread().getName() + ": " + local.get());
    }

}
