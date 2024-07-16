package CreationalPatterns.BuilderPattern.ConcreteBuilder;

import CreationalPatterns.BuilderPattern.Builder.CarBuilder;
import CreationalPatterns.BuilderPattern.Product.BenzModel;
import CreationalPatterns.BuilderPattern.Product.CarModel;

import java.util.ArrayList;

/**
 * @ClassName BenzBuilder
 * @Description 奔驰车模型的具体建造者类，建造完将该模型返回
 * @Author 彭德民
 * @Date 2022/10/17 19:40
 */

public class BenzWorker extends CarBuilder {

    private BenzModel benz = new BenzModel();

    @Override
    /**
     * @Description:设置奔驰车的执行顺序
     * @Param
     * @return void
     **/
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    /**
     * @Description:返回一个奔驰车辆模型
     * @Param
     * @return CreationalPatterns.BuilderPattern.Product.CarModel
     **/
    public CarModel getCarModel() {
        return this.benz;
    }
}
