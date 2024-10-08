package InterfaceTest;

/**
 * @ClassName Animal
 * @Author Demin Peng
 * @Date 2024/9/24 12:33
 * @Description TODO
 */
public interface Animal {
    //常量年龄为2岁
    public static final int age=2;
    //抽象方法eat()
    public abstract void eat();
    //默认方法run()
    public default void run(){
        System.out.println("动物在跑");
    }
    //静态方法sleep()
    public static void sleep(){
        System.out.println("动物在睡觉");
    }
    //私有方法play()
    private static void play(){
        System.out.println("开始游戏");
        System.out.println("暂停游戏");
        System.out.println("继续游戏");
        System.out.println("结束游戏");
    }
    //默认方法happy()
    public default void happy(){
        //调用了私有方法play()，可以减少代码冗余，同时不让接口以外访问到，具有安全性
        play();
        System.out.println("玩得很开心");
    }
}
