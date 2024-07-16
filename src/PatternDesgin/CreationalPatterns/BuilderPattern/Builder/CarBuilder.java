package CreationalPatterns.BuilderPattern.Builder;

import CreationalPatterns.BuilderPattern.Product.CarModel;

import java.util.ArrayList;

/**
 * @ClassName CarBuilder
 * @Description 汽车的抽象建造者类，规范了汽车模型建造应该
 * 要先确定建造顺序，建造完要返回该模型。但具体实现过程由其子类去实现
 * @Author 彭德民
 * @Date 2022/10/16 19:36
 */

public abstract class CarBuilder {

    //建造一个模型，首先要确定组装顺序
    public abstract void setSequence(ArrayList<String> sequence);

    //设置完顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();
}
