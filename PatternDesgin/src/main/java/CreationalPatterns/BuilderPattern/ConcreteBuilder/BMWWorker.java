package CreationalPatterns.BuilderPattern.ConcreteBuilder;

import CreationalPatterns.BuilderPattern.Builder.CarBuilder;
import CreationalPatterns.BuilderPattern.Product.BMWModel;
import CreationalPatterns.BuilderPattern.Product.CarModel;

import java.util.ArrayList;

/**
 * @ClassName BMWBuilder
 * @Description 宝马车的具体建造者类，建造完将该模型返回
 * @Author 彭德民
 * @Date 2022/10/16 19:51
 */

public class BMWWorker extends CarBuilder {

    private BMWModel bmw = new BMWModel();

    @Override
    /**
     * @Description:设置宝马车的执行顺序
     * @Param ArrayList<String>
     * @return void
     **/
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }

    @Override
    /**
     * @Description:返回一个宝马车的模型
     * @Param 
     * @return CreationalPatterns.BuilderPattern.Product.CarModel
     **/
    public CarModel getCarModel() {
        return this.bmw;
    }
}
