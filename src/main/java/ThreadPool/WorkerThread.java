package ThreadPool;

public class WorkerThread implements Runnable{
    private String task;
    public WorkerThread(String s)
    {
        this.task = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" starting. Task = "+ this.task);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " finished.");
    }

    private void processCommand()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
