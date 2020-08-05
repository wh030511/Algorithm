package exam.common;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author WuHao
 * @create 2020-03-23-10:57
 */
public class print {
    static Object lock = new Object();
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    System.out.println("a");
                    lock.notify();

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new FutureTask<Object>(new Callable<Object>(){

            @Override
            public Object call() throws Exception {
                Thread.sleep(100);
                for(int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        System.out.println("b");
                        lock.notify();
                        lock.wait();
                    }
                }
                return null;
            }
        })).start();

        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        System.out.println("c");
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


    }
}
