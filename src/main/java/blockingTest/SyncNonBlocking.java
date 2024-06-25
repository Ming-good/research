package blockingTest;

import java.util.concurrent.ExecutionException;

public class SyncNonBlocking<T> implements Process {

    @Override
    public void execution(int i) throws ExecutionException, InterruptedException {
        Thread thread = calculate(i);
        thread.start();

        System.out.println("동기 + 논블로킹 TASK 진행중 : "+i);

        while (thread.isAlive()) {
            System.out.println("동기 + 논블로킹 진행중인 TASK 대기중 : " + i);
            Thread.sleep(1000);
        }

        System.out.println("동기 + 논블로킹 TASK 완료 : " + i);
        System.out.println("동기 + 논블로킹 TASK 다른 작업 시작 : " + i);
    }

    public synchronized Thread calculate(int input) throws InterruptedException {

        return new Thread(() -> {
            try {
                System.out.println("동기 + 논블로킹 TASK 실행 : "+ input);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
