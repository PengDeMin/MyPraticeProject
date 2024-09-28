package InterfaceTest;

/**
 * @ClassName Cat
 * @Author Demin Peng
 * @Date 2024/9/24 12:35
 * @Description TODO
 */

public class Cat implements Animal{

    @Override
    public void eat() {

    }

    //这个默认方式其实是可重写也可不重写
    @Override
    public void run() {
        System.out.println("猫在跑");
    }

    @Override
    public void happy() {
        Animal.super.happy();
    }


}
