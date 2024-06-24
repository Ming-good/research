package blockingTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsyncBlocking<T> implements Process {

    @Override
    public void execution(int i) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = calculate(i);
        new Thread(futureTask).start();
        System.out.println("비동기 + 블로킹 "+i);
        System.out.println(futureTask.get());
    }

    // 비동기지만 블로킹이 발생하는 문제가 있다.
   public FutureTask<String> calculate(int input) {
        return  new FutureTask<>(() -> {
            Thread.sleep(1000);
            System.out.println("비동기 + 블로킹 TASK 실행 : " + input);
            return "비동기 + 블로킹 TASK 결과물" + input;
        });
    }
}
