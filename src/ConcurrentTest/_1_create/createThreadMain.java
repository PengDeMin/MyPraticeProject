package ConcurrentTest._1_create;

import java.util.concurrent.*;

/**
 * @ClassName createThread
 * @Description 创建线程不同方式
 * @Author 彭德民
 * @Date 2024/5/31 10:43
 */

public class createThreadMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //下面创建线程的写法都是多态的写法
        //创建线程的方式一：继承Thread类
        Thread extendsThhread = new ExtendsThread("民哥子线程1号");
        extendsThhread.start();

        //创建线程方式二.1：实现Runnable方法
        Runnable runnable = new ImplementsRunnable();//创建任务对象
        new Thread(runnable).start();//把任务对象交给线程对象，才能创建线程

        //创建线程方式二.2：实现Runnable方法的匿名内部类写法
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 5; i++) {
                    System.out.println("此刻是线程" + Thread.currentThread().getName() + "在输出" + i);
                }
            }

            ;
        };
        new Thread(target).start();

        //简化形式1
        new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 5; i++) {
                    System.out.println("此刻是线程" + Thread.currentThread().getName() + "在输出" + i);
                }
            }
        })).start();

        //简化形式2：使用Lambada表达式,因为Runnable是函数式接口
        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("此刻是线程" + Thread.currentThread().getName() + "在输出" + i);
            }
        }).start();

        //创建线程的方式三：实现callble接口,这种方式可以传入参数，并在线程执行完后获得执行结果
        Callable<String> callTarget = new ImplmentsCallable(10);//创建一个callable对象
        //将callable对象封装成FutureTask对象，未来任务对象的作用：
        //1、未来任务对象实现了Runnable，方便后面把它交给线程对象
        //2、可以在线程执行完毕后，用未来任务对象.get获取执行结果
        FutureTask<String> task = new FutureTask(callTarget);
        new Thread(task).start();
        System.out.println(task.get());


//        Future<String> oldFuture = new FutureTask<>(callTarget);
//        ExecutorService es = null;
//        es.submit(callTarget)
        for (int i = 6; i <= 10; i++) {
            System.out.println("此刻是线程" + Thread.currentThread().getName() + "在输出" + i);
        }

    }
}
