package blockingTest;

import java.util.concurrent.CompletableFuture;

public class NonBlocking implements Process {

    @Override
    public void execution(int i) {
        calculate(i).thenAccept(v -> System.out.println(v));
    }

    //자바 8부터 사용 가능하며 논블로킹이다.
    public CompletableFuture calculate(int input) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("논블로킹 TASK 실행 : "+input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "논블로킹 TASK 결과물"+input;
        });
    }
}
