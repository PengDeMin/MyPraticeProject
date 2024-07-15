package CreationalPatterns.FactoryMethod.CreateHuman;

/**
 * @ClassName YellowHuman
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/23 19:41
 */

public class YellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的！");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节。");
    }
}
