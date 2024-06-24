package blockingTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        Process<Integer> syncBlockingProcess = new SyncBlocking<Integer>();
        Process<CompletableFuture> aSyncBnonBlockingProcess = new AsyncNonBlocking<CompletableFuture>();
        Process<FutureTask> aSyncBlockingProcess = new AsyncBlocking<FutureTask>();


        syncBlockingProcess.execution(0);
        syncBlockingProcess.execution(1);

        System.out.println("------------------2초 대기..");
        Thread.sleep(2000);

        aSyncBnonBlockingProcess.execution(0);
        aSyncBnonBlockingProcess.execution(1);

        System.out.println("------------------2초 대기..");
        Thread.sleep(2000);

        aSyncBlockingProcess.execution(3);
        aSyncBlockingProcess.execution(4);

        System.out.println("Total elapsed time in millis is : " + (System.currentTimeMillis() - start));

        Thread.sleep(1000);
    }


}