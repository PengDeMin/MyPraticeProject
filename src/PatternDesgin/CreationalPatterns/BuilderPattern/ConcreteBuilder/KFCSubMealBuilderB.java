package CreationalPatterns.BuilderPattern.ConcreteBuilder;

import CreationalPatterns.BuilderPattern.Builder.KFCMealBuilder;

/**
 * @ClassName SubMealBuilderB
 * @Description 套餐的具体建造者B，自定义其套餐内容
 * @Author 彭德民
 * @Date 2022/10/22 10:28
 */

public class KFCSubMealBuilderB extends KFCMealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("一个鸡肉卷");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯咖啡");
    }
}
