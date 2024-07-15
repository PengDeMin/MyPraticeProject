package ConcurrentTest;

import ConcurrentTest._1_create.ExtendsThread;

/**
 * @ClassName CommonMethods
 * @Description 学习线程常用方法
 * @Author 彭德民
 * @Date 2024/6/1 12:06
 */

public class CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ExtendsThread("民哥子线程1号");//设置线程名字方式1
        t1.setName("民哥子线程1号");//设置线程名字方式2
        t1.start();
        System.out.println(t1.getName());//取线程名字
        t1.join();//保证当前线程先执行完，说白了就是让线程按顺序执行，变成串行方式

        Thread t2 = new ExtendsThread("民哥子线程2号");
        t2.start();
        System.out.println(t2.getName());
        t2.join();

        //让当前线程暂停,再继续执行
        Thread.sleep(5000);

        //取当前线程对象名字,下面代码是主线程在执行，因此取到主线程名字
        Thread t3 = Thread.currentThread();
        System.out.println(t3.getName());
        t3.join();
    }
}
