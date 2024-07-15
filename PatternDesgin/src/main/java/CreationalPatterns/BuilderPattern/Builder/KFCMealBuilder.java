package CreationalPatterns.BuilderPattern.Builder;

import CreationalPatterns.BuilderPattern.Product.KFCMeal;

/**
 * @ClassName MealBuilder
 * @Description 套餐的抽象建造者类,定义了抽象的组装方法，具体由其子类去实现
 * @Author 彭德民
 * @Date 2022/10/19 10:22
 */

public abstract class KFCMealBuilder {

    protected KFCMeal meal = new KFCMeal();

    public abstract void buildFood();
    public abstract void buildDrink();

    public KFCMeal getMeal() {
        return meal;
    }
}
