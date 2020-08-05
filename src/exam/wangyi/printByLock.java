package exam.wangyi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock完成轮流打印提高效率
 * @author WuHao
 * @create 2020-04-20-20:56
 */
public class printByLock implements Runnable{

    private Lock lock;
    private Condition thisCondition;
    private Condition nextCondition;
    private char printChar;

    public printByLock(Lock lock , Condition thisCondition , Condition nextCondition , char printChar){
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            for (int i = 0; i < 10 ; i++){
                System.out.println(printChar);
                nextCondition.signal();
                if (i < 9){
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

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        new Thread(new printByLock(lock, conditionB, conditionA, 'B')).start();
        new Thread(new printByLock(lock, conditionA, conditionB, 'A')).start();
    }
}
