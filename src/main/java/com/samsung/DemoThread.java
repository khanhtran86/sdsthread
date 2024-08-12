package com.samsung;

import java.util.Queue;
import java.util.Random;

public class DemoThread extends Thread{
    Queue<Integer> lstNumbers;

    public DemoThread(Queue<Integer> numbersStore)
    {
        this.lstNumbers = numbersStore;
    }
    @Override
    public void run()
    {
        while (true)
        {
            Random rdn = new Random();
            int number = rdn.nextInt();
            this.lstNumbers.add(number);
        }
    }
}
