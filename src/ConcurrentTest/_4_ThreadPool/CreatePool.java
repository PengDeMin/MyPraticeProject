package ConcurrentTest._4_ThreadPool;

import ConcurrentTest._1_create.ImplementsRunnable;
import ConcurrentTest._1_create.ImplmentsCallable;

import java.util.concurrent.*;

/**
 * @ClassName CreatePool
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/2 10:57
 */

public class CreatePool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         *一、方式一通过ExecutorService接口的实现类ThreadPoolExecutor创建线程池
         * int corePoolSize:核心（常驻）线程数量
         * int maximumPoolSize,最大线程数量
         * long keepAliveTime,临时线程空闲的存活时间
         * TimeUnit unit,存活时间的单位（秒、分、时）
         * BlockingQueue<Runnable> workQueue,任务队列
         * ThreadFactory threadFactory,线程工厂
         * RejectedExecutionHandler handler，忙不过来的拒绝策略
         */
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        ExecutorService polls = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        /**
         *二、方式二通过Executors工具类创建线程池，
         * 不过其底层本质还是通过ThreadPoolExecutor来创建线程池
         * 因此可以把它看做是对ThreadPoolExecutor的封装
         */
        ExecutorService pool2 = Executors.newFixedThreadPool(3);//创建固定只有三个线程的线程池
        ExecutorService pool3 = Executors.newSingleThreadExecutor();//创建固定只有一个线程的线程池
        ExecutorService pool4 = Executors.newCachedThreadPool();//创建随任务数量增加而线程数量增加的线程池

        //1、创建并处理Runnable任务
        Runnable ir = new ImplementsRunnable();
        pool.execute(ir);//线程池会自动创建一个新线程，自动处理该任务，自动执行！
        pool.execute(ir);//线程池会自动创建一个新线程，自动处理该任务，自动执行！
        pool.execute(ir);//线程池会自动创建一个新线程，自动处理该任务，自动执行！
        pool.execute(ir);//线程池会自动创建一个新线程，自动处理该任务，自动执行！
        pool.execute(ir);//线程池会自动创建一个新线程，自动处理该任务，自动执行！

        //2、创建并处理Callable任务
        //Future是FutureTask的一种父类形式
        Future<String> f1 = pool.submit(new ImplmentsCallable(5));
        Future<String> f2 = pool.submit(new ImplmentsCallable(8));
        Future<String> f3 = pool.submit(new ImplmentsCallable(10));
        Future<String> f4 = pool.submit(new ImplmentsCallable(13));

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());

        pool.shutdown();//等待任务全部完成才关闭
        //pool.shutdownNow();//立即关闭线程池，关闭后抛出异常显示没有执行完成的任务，这个在实际中很少用

    }


}
