package blockingTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SyncBlocking<T> implements Process {

    @Override
    public void execution(int i) throws ExecutionException, InterruptedException {
        Integer calculate = calculate(i);
        System.out.println("동기 + 블로킹 TASK 결과물 : "+calculate);
    }

   public Integer calculate(int input) throws InterruptedException {
       Thread.sleep(1000);
       System.out.println("도익 + 블로킹 TASK 실행 : "+ input);
       return input;
    }
}
