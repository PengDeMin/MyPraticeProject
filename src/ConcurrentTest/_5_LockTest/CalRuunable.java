package ConcurrentTest._5_LockTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CalRuunable
 * @Description 负责计算数值的任务对象
 * @Author 彭德民
 * @Date 2024/6/2 16:07
 */

public class CalRuunable implements Runnable {
    private static int pessimistic_lock_count = 0;//悲观锁方案的例子数值
    private static AtomicInteger optimistic_lock_count = new AtomicInteger(0);//乐观锁方案的例子数值
    @Override
    public void run() {
        //悲观锁解决线程安全问题：就是加锁
        synchronized (this) {
            for (int i = 0; i<100; i++){
                System.out.println(("悲观锁数值---->" + (++pessimistic_lock_count)));
            }
        }

        //乐观锁解决线程安全问题：CAS方案，在Java中由原子类实现
        for (int i = 0; i<100; i++){
            System.out.println(("乐观锁数值---->" + optimistic_lock_count.incrementAndGet()));
        }
    }
}
