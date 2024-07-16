package CreationalPatterns.BuilderPattern.Director;

import CreationalPatterns.BuilderPattern.Builder.KFCMealBuilder;
import CreationalPatterns.BuilderPattern.Product.KFCMeal;

/**
 * @ClassName KFCDierctor
 * @Description TODO
 * @Author 彭德民
 * @Date 2022/10/22 10:36
 */

public class KFCDirector {
    private KFCMealBuilder mealBuilder;

    public void setMealBuilder(KFCMealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public KFCMeal construct() {
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        return mealBuilder.getMeal();
    }

}
