package PatternDesgin.BehavioralPatterns.TemplateMethodPattern.Car;

/**
 * @ClassName HummerModel
 * @Description 悍马车模板父类, 带有钩子方法的扩展
 * @Author 彭德民
 * @Date 2022/10/22 16:47
 */

public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    //钩子函数，用于约束子类实现alarm方法时的行为
    /*在抽象类中，isAlarm是一个实现方法。其作用是模板方法根据其返回值决定是否要响
     *喇叭，子类可以覆写该返回值，由于H1型号的喇叭是想让它响就响，不想让它响就不响，由人控制.
     */
    protected boolean isAlarm() {
        return true;
    }

    final public void run() {
        //先发动汽车
        this.start();
        //引擎开始轰鸣
        this.engineBoom();
        //要让它叫的就是就叫，喇嘛不想让它响就不响
        if (this.isAlarm()) {
            this.alarm();
        }
        //到达目的地就停车
        this.stop();
    }

}
