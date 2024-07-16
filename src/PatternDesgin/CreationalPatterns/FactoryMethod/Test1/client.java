package CreationalPatterns.FactoryMethod.Test1;

/**
 * @ClassName client
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/11/1 20:38
 */

public class client {

    public static void main(String[] args) {

        //声明一座工厂
        AbstractTVFactory tvFactory = new HisenseTVFactory();


    }
}
