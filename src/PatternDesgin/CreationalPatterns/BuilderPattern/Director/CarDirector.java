package CreationalPatterns.BuilderPattern.Director;

import CreationalPatterns.BuilderPattern.ConcreteBuilder.BMWWorker;
import CreationalPatterns.BuilderPattern.ConcreteBuilder.BenzWorker;
import CreationalPatterns.BuilderPattern.Product.BMWModel;
import CreationalPatterns.BuilderPattern.Product.BenzModel;

import java.util.ArrayList;

/**
 * @ClassName Director
 * @Description 导演类，负责给出不同的执行顺序参数,来创建不同品牌以及不同型号的车辆模型。相当于公司老板
 * 给自己公司的生产下命令。导演类起到封装的作用，避免高层模块深入到建造者内部的实现类。
 * 当然，在建造者模 式比较庞大时，导演类可以有多个。
 * @Author 彭德民
 * @Date 2022/10/16 20:06
 */

public class CarDirector {

    //定义执行顺序的参数列表
    private ArrayList<String> sequence = new ArrayList();

    private BenzWorker benzWorker = new BenzWorker();
    private BMWWorker bmwWorker = new BMWWorker();

    //组建A型号奔驰车模型的顺序，先start，然后stop，其他什么引擎、喇叭一概没有
    public BenzModel getABenzModel() {
        System.out.println("开始组装一辆A类型的奔驰车模型");
        this.sequence.clear();
        //ABenzModel的执行顺序
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzWorker.setSequence(this.sequence);
        return (BenzModel) this.benzWorker.getCarModel();
    }

    //组建B型号奔驰车模型的顺序，是先发动引擎，然后启动，然后停止，没有喇叭
    public BenzModel getBBenzModel() {
        System.out.println("开始组装1辆B类型的奔驰车模型>>>");
        this.sequence.clear();
        this.sequence.add("engine boom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzWorker.setSequence(this.sequence);
        return (BenzModel) this.benzWorker.getCarModel();

    }

    //组建C型号宝马车模型的顺序,先按下喇叭（炫耀嘛），然后启动，然后停止 */
    public BMWModel getCBMWModel() {
        System.out.println("开始组装1辆C类型的宝马车模型>>>");
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwWorker.setSequence(this.sequence);
        return (BMWModel) this.bmwWorker.getCarModel();
    }

    //组建D型号宝马车模型的顺序，就是跑，启动起来就跑，永远不停止 */
    public BMWModel getDBMWModel() {
        System.out.println("开始组装1辆d类型的宝马车模型>>>");
        this.sequence.clear();
        this.sequence.add("start");
        this.bmwWorker.setSequence(this.sequence);
        return (BMWModel) this.benzWorker.getCarModel();
    }
}
