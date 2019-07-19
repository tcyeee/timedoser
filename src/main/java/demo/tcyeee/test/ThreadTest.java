package demo.tcyeee.test;

/**
 * @author tcyeee
 * @since 2019-04-02 13:34
 * 创建多线程的第一种方式: 继承Thread类, 重写run方法
 */
public class ThreadTest extends Thread {

    private ThreadTest() {
        // 构造方法
    }

    public void run() {
        circulation();
    }

    public static void main(String[] args) {

        ThreadTest thread1 = new ThreadTest();
        thread1.setName("diy1");
        thread1.start();   // 这里开始了diy线程1

        Thread thread2 = new Thread(new MyThread());
        thread2.setName("diy2");
        thread2.start();   // 这里开始了diy线程2

        circulation();     // 这里开启了main线程
    }

    // 使用当前线程进行计数
    static void circulation() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + i);

            // 线程sleep 0.1秒, 方便看同时进行的效果
            try {
                sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * 第二种方式启动线程
 * <p>
 * 线程实现方式2：
 * 通过实现Runnable接口，实现run方法，接口的实现类的实例作为Thread
 * 的target作为参数传入带参的Thread构造函数，通过调用start()方法启动线程
 */
class MyThread implements Runnable {

    @Override
    public void run() {
        ThreadTest.circulation();     // 这里开启了diy线程2
    }
}



