package com.mashibing.state;

public class StateRunable {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {

            }
        });

        t1.start();
        Thread.sleep(500);
        System.out.println(t1.getState());
    }
}
