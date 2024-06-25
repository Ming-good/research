package blockingTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsyncBlocking<T> implements Process {

    @Override
    public void execution(int i) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = calculate(i);
        new Thread(futureTask).start();
        System.out.println("비동기 + 블로킹 다른 작업 불가"+i);
        System.out.println(futureTask.get());
        System.out.println("비동기 + 블로킹 다른 작업 시작"+i);
    }

    // 비동기지만 블로킹이 발생하는 문제가 있다.
   public FutureTask<String> calculate(int input) {
        return  new FutureTask<>(() -> {
            System.out.println("비동기 + 블로킹 TASK 실행 : " + input);
            Thread.sleep(1000);
            return "비동기 + 블로킹 TASK 결과물" + input;
        });
    }
}
