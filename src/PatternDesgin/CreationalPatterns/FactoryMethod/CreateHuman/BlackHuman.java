package PatternDesgin.CreationalPatterns.FactoryMethod.CreateHuman;

/**
 * @ClassName BlackHUman
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/23 19:40
 */

public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的！");
    }

    @Override
    public void talk() {
        System.out.println("黑人会说话，一般人听不懂。");
    }
}
