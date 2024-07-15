package ConcurrentTest._2_SafeSimulation;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/1 12:34
 */

public class DrawMoneyTest {
    public static void main(String[] args) {
        Account acc = new Account("共同账户",10000);
        new DrawThread("老公线程",acc).start();//老公取钱线程
        new DrawThread("老婆线程",acc).start();//老婆取钱线程
    }
}
