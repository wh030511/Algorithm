package exam.common;

/**
 * @author WuHao
 * @create 2020-03-23-11:27
 */
public class productedDemo {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者");
        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者");

        p1.start();
        c1.start();
    }
}

class Clerk{
    private int count = 0;

    public synchronized void produceProduct() throws InterruptedException {
        if (count < 20){
            count++;
            System.out.println(Thread.currentThread().getName() + "生产第" + count + "个产品");
            notify();
        }else{
            wait();
        }
    }

    public synchronized void consumeProduct() throws InterruptedException {
        if (count > 0){
            System.out.println(Thread.currentThread().getName() + "消费第" + count + "个产品");
            count--;
            notify();
        }else{
            wait();
        }
    }
}


// 生产线程
class Producer extends Thread{
    Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品");

        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.produceProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 消费线程
class Consumer extends Thread{
    Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品");

        while(true){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.consumeProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
