package exam.wangyi;

/**
 * 面试题
 * @author WuHao
 * @create 2020-04-15-18:28
 */
class print {
    private static Object lock = new Object();
    public static void main(String[] args) {
        new MyPrint(lock,1).start();
        new MyPrint(lock, 2).start();
    }
}

class MyPrint extends Thread{
    private Object lock;
    private int num;
    public MyPrint(Object lock , int num){
        this.lock = lock;
        this.num = num;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            synchronized (lock) {
                System.out.println(num);
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
