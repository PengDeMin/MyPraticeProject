package CreationalPatterns.FactoryMethod.Test1;

/**
 * @ClassName TV
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/11/1 20:40
 */

public abstract class TV {
    public abstract void play();

    @Override
    public abstract TV clone();
}
