package ConcurrentTest._1_create;


import java.util.concurrent.Callable;

/**
 * @ClassName ImplmentsCallable
 * @Description 通过实现Callable创建线程"这种方式可以拿到线程执行完的返回值
 * @Author 彭德民
 * @Date 2024/5/19 17:23
 */

public class ImplmentsCallable implements Callable<String> {
    private int n;

    public ImplmentsCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() {
        //System.out.println("此时执行的线程是："+Thread.currentThread().getName());
        int sum = 0;
        for (int i = 0; i <=n;i++){
            sum += i;
        }
        return "线程"+Thread.currentThread().getName()+"计算出的数据是"+sum;
    }

}
