package ConcurrentTest;

/**
 * @ClassName PrintOddEven
 * @Author Demin Peng
 * @Date 2024/9/7 15:14
 * @Description 两个线程交替打印奇偶数1-20
 */

public class PrintOddEven {
    private static final Object lock = new Object();
    private static final int MAX_COUNT = 20;
    private static int count = 1;

    public static void main(String[] args) {
        Runnable odd = ()->{
            synchronized (lock) {
                while(count <= MAX_COUNT){
                    if(count % 2 != 0){
                        System.out.println(count);
                        count++;
                        lock.notify();
                    }else{
                        try{
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };


        Runnable even = ()->{
            synchronized (lock){
                while(count<= MAX_COUNT){
                    if(count%2 == 0){
                        System.out.println(count);
                        count++;
                        lock.notify();
                    }
                    else{
                        try {
                            lock.wait();
                        }catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
    }
}
