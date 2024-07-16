package CreationalPatterns.BuilderPattern.Director;

import CreationalPatterns.BuilderPattern.Builder.ComputerBuilder;
import CreationalPatterns.BuilderPattern.ConcreteBuilder.GameComputerWorker;
import CreationalPatterns.BuilderPattern.ConcreteBuilder.OfficeComputerWorker;

/**
 * @ClassName ComputerDierctor
 * @Description 组装电脑的指挥（导演者）类，负责组织工人组装电脑
 * @Author 彭德民
 * @Date 2022/10/16 21:52
 */

public class ComputerDirector {

    //指挥者叫来组装游戏电脑和组装办公电脑的工人
    private ComputerBuilder gameComputerWorker = new GameComputerWorker();
    private ComputerBuilder officeComputerWorker = new OfficeComputerWorker();

    //叫组装游戏电脑的工人去组装电脑，且按照指挥者制定的顺序去组装。
    public void BuildGameComputer() {
        System.out.println("开始组装一台游戏电脑>>>");
        gameComputerWorker.installMainboard();
        gameComputerWorker.installCPU();
        gameComputerWorker.installGPU();
        gameComputerWorker.installHardDisk();
        gameComputerWorker.installMemory();
        System.out.println(">>>一台游戏电脑组装完成");
        gameComputerWorker.getComputer().showInfo();
    }

    //叫组装办公电脑的工人去组装电脑，且按照指挥者制定的顺序去组装。
    public void BuildOfficeComputer() {
        System.out.println("开始组装一台办公电脑>>>");
        officeComputerWorker.installMainboard();
        officeComputerWorker.installCPU();
        officeComputerWorker.installMemory();
        officeComputerWorker.installHardDisk();
        officeComputerWorker.installGPU();
        System.out.println(">>>一台办公电脑组装完成");
        officeComputerWorker.getComputer().showInfo();
    }

}
