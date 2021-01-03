package com.okgo.javaapi.thread.threadlocal2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Shawn
 * @date 2020/12/28 17:05
 * @title Function
 */
public class ThreadLocalDemo01 {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                String data = new ThreadLocalDemo01().date(finalI);
                System.out.println(data);
            }).start();
            Thread.sleep(100);
        }

    }

    private String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        return simpleDateFormat.format(date);
    }
}
