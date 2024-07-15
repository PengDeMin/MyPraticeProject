package ConcurrentTest._2_SafeSimulation;

/**
 * @ClassName DrawThread
 * @Description 取钱线程
 * @Author 彭德民
 * @Date 2024/6/1 12:35
 */

public class DrawThread extends Thread{
    private Account acc;

    public DrawThread(String name, Account acc) {
        super(name);
        this.acc = acc;
    }

    public DrawThread(Account acc){
        this.acc = acc;
    }
    @Override
    public void run() {
        acc.drawMoney(10000);
    }
}
