package CreationalPatterns.BuilderPattern.ConcreteBuilder;

import CreationalPatterns.BuilderPattern.Builder.ComputerBuilder;

/**
 * @ClassName OfficeComputerBuilder
 * @Description 办公电脑的具体建造者类，即负责组装办公电脑的工人
 * @Author 彭德民
 * @Date 2022/10/16 21:48
 */

public class OfficeComputerWorker extends ComputerBuilder {

    //给办公电脑装相应特色的配件
    @Override
    public void installCPU() {
        computer.setCPU("i5-12400H");
    }

    @Override
    public void installGPU() {
        computer.setGPU("没有独立显卡");
    }

    @Override
    public void installMemory() {
        computer.setMemory("16GB");
    }

    @Override
    public void installMainboard() {
        computer.setMainboard("MSI HM170");
    }

    @Override
    public void installHardDisk() {
        computer.setHardDisk("512GB SSD");
    }

}
