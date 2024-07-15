package ConcurrentTest._3_Communication;

/**
 * @ClassName ThreadCommunication
 * @Description 线程通信模拟 生产者-消费者模型
 * @Author 彭德民
 * @Date 2024/6/1 14:02
 */

public class ThreadCommunication {

    public static void main(String[] args) {
        Desk desk = new Desk();

        //采用lambada代替匿名内部类对象的方式创建3个生产者线程
        for (int i = 1; i < 4 ; i++) {
            new Thread(()->{
                while (true) {
                    desk.put();
                }
            },"厨师线程"+i).start();
        }

        //创建2个消费者线程
        for (int i = 1; i < 3 ; i++) {
            new Thread(()->{
                while (true) {
                    desk.get();
                }
            },"吃货线程"+i).start();
        }
    }
}
