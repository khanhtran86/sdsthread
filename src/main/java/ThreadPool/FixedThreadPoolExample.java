package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static final int NUMBER_OF_THREAD = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREAD);

        for(int i=1; i<=1000; i++)
        {
            //Runnable worker = new WorkerThread(String.valueOf(i));
            Runnable worker = new WorkerThread(""+i);
            executor.execute(worker);

            System.out.println("Created thread no: "+ i);
        }

        executor.shutdown();
    }
}
