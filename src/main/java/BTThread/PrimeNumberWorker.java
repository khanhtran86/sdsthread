package BTThread;

public class PrimeNumberWorker implements Runnable{
    private int numberToCheck;
    public PrimeNumberWorker(int number)
    {
        this.numberToCheck = number;
    }

    @Override
    public void run() {
        if(isPrimeNumber(this.numberToCheck))
        {
            System.out.println(this.numberToCheck);
        }
    }

    private boolean isPrimeNumber(int number)
    {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number%i==0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
