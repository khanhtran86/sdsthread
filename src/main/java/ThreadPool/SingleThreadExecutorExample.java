package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for(int i=1; i<=10; i++)
        {
            //Runnable worker = new WorkerThread(String.valueOf(i));
            Runnable worker = new WorkerThread(""+i);
            executor.execute(worker);

            System.out.println("Created thread no: "+ i);
        }

        executor.shutdown();
    }
}
