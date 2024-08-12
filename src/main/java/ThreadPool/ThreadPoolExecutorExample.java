package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        int queueCapacity = 100;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, //Số thread tiêu chuẩn
                maximumPoolSize, //Số thread tối đa có thể có trong pool
                10, //THời gian một thread có thể sống nếu không làm gì
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity)); //Đầu việc

        for (int i = 0; i < 1000; i++) {
            Runnable worker = new WorkerThread(""+i);
            executor.execute(worker);
            Thread.sleep(50);
        }

        executor.shutdown();
    }
}
