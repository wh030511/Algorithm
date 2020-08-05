package exam.common;

/**
 * @author WuHao
 * @create 2020-03-22-11:52
 */
public class TwoLockPrinter implements Runnable {
    private static final int COUNT = 10; // 连续打印10次
    private final Object fontLock;
    private final Object thisLock;
    private final char printChar;

    public  TwoLockPrinter(Object fontLock,Object thisLock,char printChar){
        this.fontLock = fontLock;
        this.thisLock = thisLock;
        this.printChar = printChar;
    }


    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++){
            synchronized (fontLock){ // 拿到前一个线程的锁
                // 获取本线程的锁
                synchronized (thisLock){
                    // 打印字符
                    System.out.println(printChar);
                    // 通过本线程的锁唤醒其他线程
                    thisLock.notify();
                }
                // 不是最后一次则通过fontLock等待被唤醒
                if (i < COUNT - 1){
                    try {
                        fontLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // A、B、C线程的锁
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();

        new Thread(new TwoLockPrinter(lockC, lockA, 'A')).start();
        Thread.sleep(100);
        new Thread(new TwoLockPrinter(lockA, lockB, 'B')).start();
        Thread.sleep(100);
        new Thread(new TwoLockPrinter(lockB, lockC, 'C')).start();
        Thread.sleep(100);

    }
}
