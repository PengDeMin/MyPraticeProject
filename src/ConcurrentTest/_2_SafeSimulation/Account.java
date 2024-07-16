package ConcurrentTest._2_SafeSimulation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Account
 * @Description 账户对象
 * @Author 彭德民
 * @Date 2024/6/1 12:32
 */

public class Account {

    private String cardId;
    private double money;

    //为一个账户对象创建一个专属于它的锁对象
    private final Lock lk = new ReentrantLock();

    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private static void test1() {
        //在静态方法中对同步代码块加锁使用类字节码对象，系统仅此一份
        synchronized (Account.class) {

        }
    }

    //采用同步代码块加锁
    public void drawMoney(double i) {
        //搞清楚谁来取钱
        String name = Thread.currentThread().getName();
        //下面这句：进来的线程拿到"字符串的锁对象"才能进入同步代码块，这种全系统唯一一份的锁对象不好，会锁住所有户人家的账户
        //synchronized ("字符串的锁对象") {
        //应该采用每家人自己的账户account作为锁对象,上锁只会锁住自己家的账户，不影响别的账户取钱
        synchronized (this) {
            if (this.money >= i) {
                this.money -= i;
                System.out.println(name + "来取" + i + "元啦！取钱成功，余额为：" + money + "元");
            } else {
                System.out.println(name + "来取" + i + "元啦！取钱失败，余额不足！");
            }
        }

    }

    //直接采用同步方法加锁
    public synchronized void drawMoney2(double i) {
        //搞清楚谁来取钱
        String name = Thread.currentThread().getName();
        if (this.money >= i) {
            this.money -= i;
            System.out.println(name + "来取" + i + "元啦！取钱成功，余额为：" + money + "元");
        } else {
            System.out.println(name + "来取" + i + "元啦！取钱失败，余额不足！");
        }

    }

    //采用Lock方式加锁
    public void drawMoney3(double i) {
        //搞清楚谁来取钱
        String name = Thread.currentThread().getName();
        //进来的线程对自家账户加锁
        lk.lock();
        try {
            if (this.money >= i) {
                this.money -= i;
                System.out.println(name + "来取" + i + "元啦！取钱成功，余额为：" + money + "元");
            } else {
                System.out.println(name + "来取" + i + "元啦！取钱失败，余额不足！");
            }
        } finally {
            //进来的线程执行完对自家账户解锁
            //将解锁操作放入finally中：使得即使try块中的代码执行出错跳出，也任然可以安全
            //地在fainally中解锁
            lk.unlock();
        }
    }
}
