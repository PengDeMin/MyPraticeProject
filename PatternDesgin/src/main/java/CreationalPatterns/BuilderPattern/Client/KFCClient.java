package CreationalPatterns.BuilderPattern.Client;

import CreationalPatterns.BuilderPattern.ConcreteBuilder.KFCSubMealBuilderA;
import CreationalPatterns.BuilderPattern.Director.KFCDirector;
import CreationalPatterns.BuilderPattern.Product.KFCMeal;

/**
 * @ClassName KFCClient
 * @Description KFC的客户端类
 * @Author 彭德民
 * @Date 2022/10/19 10:40
 */

public class KFCClient {

    public static void main(String args[])
    {

        KFCDirector director = new KFCDirector();
        director.setMealBuilder(new KFCSubMealBuilderA());
        KFCMeal meal = director.construct();

        System.out.println("套餐组成：");
        System.out.println(meal.getFood());
        System.out.println(meal.getDrink());
    }

}
