package exam.common;

/**
 * @author WuHao
 * @create 2020-03-23-10:51
 */
public class deadlock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(){
            @Override
            public void run() {
                synchronized (lock1){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("成功");
                    }
                }
            }
        }.start();

        new Thread(new Runnable(){

            @Override
            public void run() {
                synchronized (lock2){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("成功1");
                    }
                }
            }
        }).start();
    }
}
