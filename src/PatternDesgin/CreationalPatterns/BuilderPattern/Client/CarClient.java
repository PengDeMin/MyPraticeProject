package CreationalPatterns.BuilderPattern.Client;

import CreationalPatterns.BuilderPattern.Director.CarDirector;

import java.util.Scanner;

/**
 * @ClassName CreationalPatterns.BuilderPattern.Client
 * @Description 场景类（客户端类）。客户找到公司老板，给老板下车辆模型的订单，然后老板就把命令传递给我，
 * 我和我的团队就开始拼命地建造，于是一个项目建设完毕了。
 * @Author 彭德民
 * @Date 2022/10/16 20:14
 */

public class CarClient {
    public static void main(String[] args) {
        //叫来组装汽车模型的指挥者（导演），准备给他下订单
        CarDirector director = new CarDirector();

        Scanner in = new Scanner(System.in);
        //客户下A类型的奔驰车模型订单
        System.out.print("请输入要下的A类型的奔驰车模型订单数量:");
        int ABenzNUM = in.nextInt();

        //客户下B类型的奔驰车模型订单
        System.out.print("请输入要下的B类型的奔驰车模型订单数量:");
        int BBenzNUM = in.nextInt();

        //客户下C类型的宝马车模型订单
        System.out.print("请输入要下的c类型的宝马车模型订单数量:");
        int CBMWNUM = in.nextInt();

        //老板叫人去建造
        for (int i = 0; i < ABenzNUM; i++) {
            director.getABenzModel().run();
        }
        System.out.println(ABenzNUM + "辆A类型的奔驰车模型订单完成");
        System.out.println();

        for (int i = 0; i < BBenzNUM; i++) {
            director.getBBenzModel().run();
        }
        System.out.println(BBenzNUM + "辆B类型的奔驰车模型订单完成");
        System.out.println();

        for (int i = 0; i < CBMWNUM; i++) {
            director.getCBMWModel().run();
        }
        System.out.print(CBMWNUM + "辆C类型的宝马车订单完成");
    }
}
