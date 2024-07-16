package CreationalPatterns.BuilderPattern.ConcreteBuilder;

import CreationalPatterns.BuilderPattern.Builder.ComputerBuilder;

/**
 * @ClassName GameComputerWorker
 * @Description 游戏电脑的具体建造者类，即负责组装游戏电脑的工人
 * @Author 彭德民
 * @Date 2022/10/16 21:42
 */

public class GameComputerWorker extends ComputerBuilder {


    //给游戏电脑装相应特色的配件
    @Override
    public void installCPU() {
        computer.setCPU("i7-12700H");
    }

    @Override
    public void installGPU() {
        this.computer.setGPU("RTX 3060");
    }

    @Override
    public void installMemory() {
        computer.setMemory("32GB");
    }

    @Override
    public void installMainboard() {
        computer.setMainboard("MSI Z490");
    }

    @Override
    public void installHardDisk() {
        computer.setHardDisk("2TB SSD");
    }

}
