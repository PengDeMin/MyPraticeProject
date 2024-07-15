package CreationalPatterns.BuilderPattern.Product;

/**
 * @ClassName ComputerModel
 * @Description 电脑产品类
 * @Author 彭德民
 * @Date 2022/10/16 21:10
 */

public class Computer {

    //定义电脑部件
    private String CPU;
    private String GPU;
    private String memory;
    private String mainboard;
    private String hardDisk;

    public void setCPU(String CPU) {this.CPU = CPU;}
    public void setGPU(String GPU) {this.GPU = GPU;}
    public void setMemory(String memory) {this.memory = memory;}
    public void setMainboard(String mainboard) {this.mainboard = mainboard;}
    public void setHardDisk(String hardDisk) {this.hardDisk = hardDisk;}

    public String getCPU() {return CPU;}
    public String getGPU() {return GPU;}
    public String getMemory() {return memory;}
    public String getMainboard() {return mainboard;}
    public String getHardDisk() {return hardDisk;}

    //展示电脑配置信息
    public void showInfo(){
        System.out.println("=======本电脑配置信息=======");
        System.out.println("CPU类型：" + CPU);
        System.out.println("显卡类型：" + GPU);
        System.out.println("主板类型：" + mainboard);
        System.out.println("内存类型：" + memory);
        System.out.println("硬盘类型：" + hardDisk);
        System.out.println("=====================");
    }
}
