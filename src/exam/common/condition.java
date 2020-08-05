package exam.common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WuHao
 * @create 2020-03-24-9:33
 */
public class condition implements Runnable{

    private ReentrantLock lock;
    private Condition thisCondition;
    private Condition nextCondition;
    private char printChar;
    private final int count = 10;

    public condition(ReentrantLock lock, Condition thisCondition, Condition nextCondition,char printChar) {
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        lock.lock(); // 显示锁 进入临界区
        try{
            for (int i = 0; i < count; i++){
                System.out.print(printChar);
                nextCondition.signal();
                if (i < count-1){
                    try {
                        thisCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        new Thread(new condition(lock, conditionA, conditionB, 'A')).start();
        Thread.sleep(100);
        new Thread(new condition(lock, conditionB, conditionC, 'B')).start();
        Thread.sleep(100);
        new Thread(new condition(lock, conditionC, conditionA, 'C')).start();
    }
}
