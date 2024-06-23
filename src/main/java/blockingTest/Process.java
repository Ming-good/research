package blockingTest;

import java.util.concurrent.ExecutionException;

public interface Process<T> {
    void execution(int i) throws ExecutionException, InterruptedException;

    T calculate(int i);
}
