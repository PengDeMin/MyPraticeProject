package ConcurrentTest._1_create;

/**
 * @ClassName ImplementsRunnable
 * @Description 通过实现Runnable接口创建线程
 * @Author 彭德民
 * @Date 2024/5/19 17:21
 */

public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "在输出" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
