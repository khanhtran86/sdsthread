package com.samsung;

import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //Run thread from extend thread class
        DemoThread thread = new DemoThread(queue);
        thread.setPriority(2);
        thread.start();

        //Run thread from runable implement
        Thread thread2 = new Thread(new DemoThread2(queue), "Thread 2 Demo");
        thread2.setPriority(1);
        thread2.start();


    }
}
