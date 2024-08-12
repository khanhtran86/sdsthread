package BTThread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    private static final int NUMBER_OF_THREAD = 5;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
        for (int i = 0; i < 10000; i++) {
            Random rdn = new Random();
            int number = 10000 + rdn.nextInt(89999);

            executor.execute(new PrimeNumberWorker(number));
        }

        executor.shutdown();
    }
}
