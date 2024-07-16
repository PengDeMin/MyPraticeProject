package PatternDesgin.CreationalPatterns.FactoryMethod.CreateHuman;

/**
 * @ClassName WhiteHuman
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/23 19:42
 */

public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的！");
    }

    @Override
    public void talk() {
        System.out.println("白色人种会说话，一般都是但是单字节。");
    }
}
