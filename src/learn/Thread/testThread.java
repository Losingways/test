package learn.Thread;

public class testThread implements Runnable {
        
    private static String winner;
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0)
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if (over(i)) {
                break;
            }
            
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
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

    public static void main(String[] args) {
        testThread t1 = new testThread();
        new Thread(t1,"兔子").start();
        new Thread(t1,"乌龟").start();
    }
}
