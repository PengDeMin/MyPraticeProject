package CreationalPatterns.FactoryMethod.CreateHuman;

/**
 * @ClassName AbstractHumanFactory
 * @Description /*创建一个产品对象，其输入参数类型可以自行设置，
 * 通常为String、Enum、Class等，当然也可以为空
 * @Author 彭德民
 * @Date 2022/10/23 19:44
 */

public abstract class AbstractHumanFactory {

    //采用泛型，通过定义泛型对createHuman的输入参数产
    //生两层限制：1、必须是Class类型； 2、必须是Human的实现类
    //其中的"T"表示的是，只要实现了Human接口的类都可以作为参数
    public abstract <T extends Human> T createHuman(Class<T> c);
}
