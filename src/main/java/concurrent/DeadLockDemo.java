package concurrent;


import java.util.concurrent.locks.Lock;

import static com.sun.tools.doclint.Entity.ne;

/**
 * java 线程死锁实例
 * <p>
 * 线程死锁：两个线程互相持有对方需要的锁，造成的循环依赖而陷入的僵局
 */
class LockThread extends Thread {
    private String lockStr1;
    private String lockStr2;
    private String threadName;


    public LockThread(String lockStr1, String lockStr2, String threadName) {
        this.lockStr1 = lockStr1;
        this.lockStr2 = lockStr2;
        this.threadName = threadName;
    }


    @Override
    public void run() {

        synchronized (lockStr1) {
            System.out.println("Thread " + threadName + " get lock " + lockStr1);

            synchronized (lockStr2) {
                System.out.println("Thread " + threadName + " get lock " + lockStr2);


            }

        }

    }

    public static void main(String[] args) throws InterruptedException {

        LockThread thread1 = new LockThread("la", "lb", "thread 1");
        LockThread thread2 = new LockThread("lb", "la", "thread 2");


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }


}
