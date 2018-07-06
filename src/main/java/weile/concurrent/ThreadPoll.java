package weile.concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池实例，利用多线程
 */
public class ThreadPoll {


    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 10; i++) {
            executorService.execute(new WorkerThread("t"+i));
        }

    }


}

class WorkerThread extends Thread {

    @Override
    public void run() {

        System.out.println("thread:" + getName() + "working .....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public WorkerThread(String name) {
        super(name);
    }
}

