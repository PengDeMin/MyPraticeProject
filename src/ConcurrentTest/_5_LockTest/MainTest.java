package ConcurrentTest._5_LockTest;

/**
 * @ClassName MainTest
 * @Description 实现又要线程安全又要同时执行
 * @Author 彭德民
 * @Date 2024/6/2 16:09
 */

public class MainTest {
    public static void main(String[] args) {
        Runnable test = new CalRuunable();
        for (int i = 0; i < 100; i++) {
            new Thread(test).start();
        }
    }
}
