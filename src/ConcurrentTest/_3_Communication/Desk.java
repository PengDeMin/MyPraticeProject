package ConcurrentTest._3_Communication;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Desk
 * @Description 放包子的桌子，假定桌子上最多只能放一个包子
 * @Author 彭德民
 * @Date 2024/6/1 14:05
 */

public class Desk {
    private List<String> list = new ArrayList<>();

    //厨师放包子，每次只能一个人放
    //因为synchronized默认采用this作为锁对象，因此
    //既锁住了厨师进程，也锁住了吃货进程
    public synchronized void put(){
        String name = Thread.currentThread().getName();
        try {
            if(list.isEmpty()){
                list.add(name+"做的肉包子");
                System.out.println(name+"做了一个肉包子！");
                Thread.sleep(2000);//沉睡是为了显得师傅做包子花了时间

                //做完包子后，唤醒别人，沉睡自己
                //注意顺序一定是先唤醒别人，再让自己等待
                this.notify();
                this.wait();
            }else{
                //有包子了，不做了，唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //吃货进程取包子，每次只能一个人取
    public synchronized void get() {
        String name = Thread.currentThread().getName();
        try {
            if(!list.isEmpty()){
                //有包子，吃了
                System.out.println(name+"吃了包子，这个包子是："+list.get(0));
                list.clear();
                Thread.sleep(2000);//沉睡是为了显得吃货吃包子花了时间
                //吃完包子后，唤醒别的进程（可能是厨师进程也可能是吃货进程，并让自己陷入等待）
                this.notifyAll();
                this.wait();
            }
            else{
                //没有包子吃，唤醒别人，让自己等待
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
