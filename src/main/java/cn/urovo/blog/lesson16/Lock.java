package cn.urovo.blog.lesson16;

/**
 * @url https://blog.csdn.net/qq_39101581/article/details/82144499
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-26 14:37
 **/
public class Lock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();

    }

}

class Count {

    //不可重入锁
//    static Lock lock = new Lock();

    //可重入锁
    static Lock2 lock = new Lock2();

    public static void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unlock();
    }

    public static void doAdd() throws InterruptedException {
        lock.lock();
        System.out.println("2021年1月26日14:39:30...");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        print();
    }

}

/**
 * 可重入锁实现原理:
 * 通过为每个锁关联一个请求计数器和一个占有它的线程。
 * 当计数为0时，认为锁是未被占有的；
 * 线程请求一个未被占有的锁时，JVM将记录锁的占有者，并且将请求计数器置为1
 */
class Lock2 {

    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock()
            throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked && lockedBy != thread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }


}

