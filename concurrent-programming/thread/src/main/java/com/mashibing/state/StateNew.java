package com.mashibing.state;

public class StateNew {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
        });
        System.out.println(t1.getState());
    }
}
