package CreationalPatterns.FactoryMethod.CreateHuman;

/**
 * @ClassName NvWa
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/23 20:26
 */

public class NvWa {

    public static void main(String[] args) throws Exception {

        //声明阴阳八卦炉
        AbstractHumanFactory YinYangLu = new ConcreteHumanFactory();

        //女娲第一次造人，火候不足，于是白人产生了
        System.out.println("--造出的第一批人是白色人种--");
        Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class);
        //得到白人子类的实例化对象后，调用它的肤色、讲话方法自然得到的是相应子类里重写的方法
        whiteHuman.getColor();
        whiteHuman.talk();

        //女娲第二次造人，火候过足，于是黑人产生了
        System.out.println("\n--造出的第二批人是黑色人种--");
        Human blackHuman = YinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        //第三次造人，火候刚刚好，于是黄色人种产生了
        System.out.println("\n--造出的第三批人是黄色人种--");
        Human yellowHuman = YinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

    }
}
