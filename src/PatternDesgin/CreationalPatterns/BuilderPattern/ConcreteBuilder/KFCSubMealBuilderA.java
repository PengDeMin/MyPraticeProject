package PatternDesgin.CreationalPatterns.BuilderPattern.ConcreteBuilder;


import PatternDesgin.CreationalPatterns.BuilderPattern.Builder.KFCMealBuilder;

/**
 * @ClassName SubMealBuilderA
 * @Description 具体的套餐建造者A，自定义其套餐内容
 * @Author 彭德民
 * @Date 2022/10/22 10:26
 */

public class KFCSubMealBuilderA extends KFCMealBuilder {

    @Override
    public void buildFood() {
        //因为继承了父类，同时也就继承了父类的对象，不用再重新定义对象
        meal.setFood("一个鸡腿汉堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯大杯可乐");
    }
}
