package com.samsung;

import java.util.Queue;

public class DemoThread2 implements Runnable{
    Queue<Integer> numberStore;
    public DemoThread2(Queue<Integer> numberStore)
    {
        this.numberStore = numberStore;
    }

    @Override
    public void run() {
        while (!numberStore.isEmpty())
        {
            System.out.println(numberStore.poll());
        }
    }
}
