package ConcurrentTest._6_TIMU;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Demo1
 * @Description 有100份礼品，由2个人（线程）往外送，剩余10份就不送了
 * 打印送礼品信息，并打印各自送了多少份礼物
 * @Author 彭德民
 * @Date 2024/6/2 16:47
 */

public class Demo1 {
    private static AtomicInteger giftAmount = new AtomicInteger(20);

    public static void main(String[] args) {


        new Thread(new Runnable() {
            int xiaoMingCount = 0;
            @Override
            public void run() {
                while (distributeGfit()) {
                    xiaoMingCount++;
                }
                System.out.println(Thread.currentThread().getName()+"发了"+xiaoMingCount+"份礼物");
            }
        }, "小明").start();

        new Thread(new Runnable() {
            int xiaoHongCount = 0;
            @Override
            public void run() {
                while (distributeGfit()) {
                    xiaoHongCount++;
                }
                System.out.println(Thread.currentThread().getName()+"发了"+xiaoHongCount+"份礼物");
            }
        }, "小红").start();


        //new Thread(() -> distributeGfit(), "小红").start();
    }

    //分发礼物每次发一份
    private static boolean distributeGfit() {
        if (giftAmount.get() > 10) {
            int amount  = giftAmount.get();
            giftAmount.decrementAndGet();
            System.out.println(Thread.currentThread().getName() + "成功分发了一份礼物，还剩余" + (amount-1) + "份礼物");
            return true;
        }
        return false;
    }
}


