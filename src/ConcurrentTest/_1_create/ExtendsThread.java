package ConcurrentTest._1_create;

/**
 * @ClassName ExtendsThread
 * @Description 通过继承Thread方创建的线程
 * @Author 彭德民
 * @Date 2024/5/19 17:18
 */

public class ExtendsThread extends Thread {
    public ExtendsThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("此刻是线程" + Thread.currentThread().getName() + "在输出" + i);
        }
    }

}
