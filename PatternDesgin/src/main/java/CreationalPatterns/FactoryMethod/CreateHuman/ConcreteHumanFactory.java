package CreationalPatterns.FactoryMethod.CreateHuman;

/**
 * @ClassName HumanFactory
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/23 19:43
 */

public class ConcreteHumanFactory extends AbstractHumanFactory{


    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            //返回c.getName()指定的那个子类的实例，jdk1.8之前的，已经过时
            human = (T)Class.forName(c.getName()).newInstance();

            //返回c.getName()指定的那个子类的实例，java9之后的，
            Class<?> clazz = Class.forName(c.getName());
            human = (T)clazz.getDeclaredConstructor().newInstance();

        }catch (Exception e) {
            System.out.println("人中生成错误");
        }
        return (T)human;
    }
}
