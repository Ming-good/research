package blockingTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        Process<FutureTask> blockingProcess = new Blocking();
        Process<FutureTask> nonBlockingProcess = new NonBlocking();

        nonBlockingProcess.execution(0);
        nonBlockingProcess.execution(1);
        nonBlockingProcess.execution(2);

        blockingProcess.execution(3);
        blockingProcess.execution(4);
        blockingProcess.execution(5);

        System.out.println("Total elapsed time in millis is : " + (System.currentTimeMillis() - start));

        Thread.sleep(1000);
    }


}