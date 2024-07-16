package PatternDesgin.CreationalPatterns.BuilderPattern.Product;

/**
 * @ClassName BMWModel
 * @Description 宝马车的产品子类，负责实现汽车产品父类，来自定义宝马模型自己的特色
 * @Author 彭德民
 * @Date 2022/10/16 19:44
 */

public class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("宝马车跑起来是这个样子的...");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车应该这样停车...");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马车的喇叭声音是这个样子的...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马车的引擎是这个声音的...");
    }
}
