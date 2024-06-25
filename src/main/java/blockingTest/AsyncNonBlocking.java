package blockingTest;

import java.util.concurrent.CompletableFuture;

public class AsyncNonBlocking<T> implements Process {

    @Override
    public void execution(int i) {
        calculate(i).thenAccept(v -> System.out.println(v));
        System.out.println("비동기 + 논블로킹 다른 작업 진행 : " + i);
    }

    //자바 8부터 사용 가능하며 논블로킹이다.
    public CompletableFuture calculate(int input) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("비동기 + 논블로킹 TASK 실행 : "+input);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "비동기 + 논블로킹 TASK 결과물"+input;
        });
    }
}
