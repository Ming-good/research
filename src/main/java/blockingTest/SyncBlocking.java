package blockingTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SyncBlocking<T> implements Process {

    @Override
    public void execution(int i) throws ExecutionException, InterruptedException {
        Thread thread = calculate(i);
        thread.start();
        System.out.println("동기 + 블로킹 TASK 완료 : "+i);
        System.out.println("동기 + 블로킹 TASK 다른 작업 시작 : " + i);
    }

    public synchronized Thread calculate(int input) throws InterruptedException {
        return new Thread(()->{
            try {
                System.out.println("동기 + 블로킹 TASK 실행 : "+ input);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
