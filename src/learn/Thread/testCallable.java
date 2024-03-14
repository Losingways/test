package learn.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class testCallable implements Callable<Boolean> {
    private String winner;

    @Override
    public Boolean call() throws Exception {
        int i;
        for (i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && i % 10 == 0)
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if (over(i)) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        if (i < 100)
            return false;
        return true;
    }

    private boolean over(int i) {
        if (winner != null)
            return true;
        if (i < 100)
            return false;
        winner = Thread.currentThread().getName();
        System.out.println(winner + "胜利");
        return true;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        testCallable t1 = new testCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Boolean> re1 = executorService.submit(t1);
        Future<Boolean> re2 = executorService.submit(t1);
        Boolean r1 = re1.get();
        Boolean r2 = re2.get();
        System.out.println("r1:" + r1 + "  r2:" + r2);
        executorService.shutdown();
    }
}