package BehavioralPatterns.TemplateMethodPattern.Car;

/**
 * @ClassName HummerH1
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/22 16:57
 */

public class HummerH1 extends HummerModel {

    private boolean alarmFlag = true; //要响喇叭

    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H1引擎声音是这样的...");
    }

    @Override
    protected void start() {
        System.out.println("悍马H1发动...");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H1停车...");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }


    //要不要响喇叭，是由客户来决定的
    public void setAlarm(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}
