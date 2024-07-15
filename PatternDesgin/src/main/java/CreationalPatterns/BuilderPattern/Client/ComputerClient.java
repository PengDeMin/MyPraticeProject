package CreationalPatterns.BuilderPattern.Client;

import CreationalPatterns.BuilderPattern.Director.ComputerDirector;

import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName Computer
 * @Description 场景类，即客户端类
 * @Author 彭德民
 * @Date 2022/10/16 22:09
 */

public class ComputerClient {

    public static void main(String[] args) throws IOException {
        //叫来组装电脑的指挥者（导演），准备给他下订单
        ComputerDirector computerDierctor = new ComputerDirector();

        Scanner in = new Scanner(System.in);
        //客户下游戏电脑订单
        System.out.print("请输入要下的游戏电脑订单数量:");
        int gameComputerNUM = in.nextInt();

        //客户下办公电脑订单
        System.out.print("请输入要下的办公电脑订单数量:");
        int officeComputerNUM = in.nextInt();

        //老板叫人去建造
        for (int i = 0; i < gameComputerNUM; i++) {
            computerDierctor.BuildGameComputer();
        }
        System.out.println(gameComputerNUM+"台游戏电脑订单完成");

        //客户下办公电脑订单
        for (int i = 0; i < officeComputerNUM; i++) {
            computerDierctor.BuildOfficeComputer();
        }
        System.out.println(officeComputerNUM+"台办公电脑订单完成");
    }
}
