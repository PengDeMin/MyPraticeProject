package ConcurrentTest._6_TIMU;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SendThread
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/2 17:33
 */

public class SendThread extends Thread {
    private Integer giftAmount;

    public int getThisDistributeAmount() {
        return thisDistributeAmount;
    }

    public void setThisDistributeAmount(int thisDistributeAmount) {
        this.thisDistributeAmount = thisDistributeAmount;
    }

    private int thisDistributeAmount=0;

    public SendThread( String name, int giftAmount) {
        super(name);
        this.giftAmount = giftAmount;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            synchronized (giftAmount){
                if (giftAmount>10){
                    System.out.println(name + "发出了一份礼物");
                    giftAmount--;
                    thisDistributeAmount++;
                }
            }
        }
    }
}
