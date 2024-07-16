package PatternDesgin.CreationalPatterns.BuilderPattern.Builder;

import PatternDesgin.CreationalPatterns.BuilderPattern.Product.Computer;

/**
 * @ClassName ComputerBuilder
 * @Description 电脑的抽象建造者类，负责规范电脑产品的组建
 * @Author 彭德民
 * @Date 2022/10/16 21:37
 */

public abstract class ComputerBuilder {

    //定义一个电脑产品对象
    protected Computer computer;

    public Computer getComputer() {
        return this.computer;
    }

    //定义安装各个配件的抽象类
    public abstract void installCPU();

    public abstract void installGPU();

    public abstract void installMemory();

    public abstract void installMainboard();

    public abstract void installHardDisk();

}
