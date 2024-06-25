package blockingTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        Process<Thread> aSyncNonBlockingProcess = new AsyncNonBlocking<Thread>();
        Process<Thread> syncNonBlockingProcess = new SyncNonBlocking<Thread>();
        Process<CompletableFuture> aSyncBnonBlockingProcess = new AsyncNonBlocking<CompletableFuture>();
        Process<FutureTask> aSyncBlockingProcess = new AsyncBlocking<FutureTask>();

        aSyncNonBlockingProcess.execution(0);

        System.out.println("------------------2초 대기..");
        Thread.sleep(2000);

        syncNonBlockingProcess.execution(1);

        System.out.println("------------------2초 대기..");
        Thread.sleep(2000);

        aSyncBnonBlockingProcess.execution(2);

        System.out.println("------------------2초 대기..");
        Thread.sleep(2000);

        aSyncBlockingProcess.execution(3);

        System.out.println("Total elapsed time in millis is : " + (System.currentTimeMillis() - start));

        Thread.sleep(1000);
    }


}