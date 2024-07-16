package PatternDesgin.CreationalPatterns.BuilderPattern.Product;

/**
 * @ClassName CarModel
 * @Description 汽车模型产品父类
 * @Author 彭德民
 * @Date 2022/10/17 19:04
 */

import java.util.ArrayList;

public abstract class CarModel {
    //各个基本方法执行的顺序
    private ArrayList<String> sequence = new ArrayList<String>();

    //汽车模型启动
    protected abstract void start();

    //汽车模型停止
    protected abstract void stop();

    //汽车模型喇叭响
    protected abstract void alarm();

    //汽车模型引擎响
    protected abstract void engineBoom();

    //汽车模型跑起来的各部件执行程序
    final public void run() {
        this.sequence.forEach(i -> {
            String actionName = i;
            if (actionName.equalsIgnoreCase("start")) {
                this.start(); //启动汽车
            } else if (actionName.equalsIgnoreCase("stop")) {
                this.stop(); //停止汽车
            } else if (actionName.equalsIgnoreCase("alarm")) {
                this.alarm(); //喇叭开始叫了
            } else if (actionName.equalsIgnoreCase("engine boom")) {
                this.engineBoom(); //引擎开始轰鸣
            }
        });
    }

    //把传递过来的执行顺序传递到类内
    final public void setSequence(ArrayList sequence) {
        this.sequence = sequence;
    }

}
