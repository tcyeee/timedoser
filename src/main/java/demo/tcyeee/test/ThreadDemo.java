package demo.tcyeee.test;

/**
 * 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，
 * 交替打印10次ABC。这个问题用Object的wait()，notify()就可以很方便的解决。
 * 代码如下：
 *
 * @author tcyeee
 * @since 2019-04-03 17:09
 */
class ThreadDemo implements Runnable {

    private String name;
    private final Object prev;
    private final Object self;

    private ThreadDemo(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadDemo pa = new ThreadDemo("A", c, a);
        ThreadDemo pb = new ThreadDemo("B", a, b);
        ThreadDemo pc = new ThreadDemo("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
