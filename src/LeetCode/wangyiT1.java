package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName wangyiT1
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/20 19:34
 */

public class wangyiT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> xiaoAttack = new ArrayList<>();
        List<Integer> xiaoBoold = new ArrayList<>();
        List<Integer> oppoAttack = new ArrayList<>();
        List<Integer> oppoBoold = new ArrayList<>();

        for(int i=0; i<5; i++){
            xiaoAttack.add(scanner.nextInt());
        }
        for(int i=0; i<5; i++){
            xiaoBoold.add(scanner.nextInt());
        }
        for(int i=0; i<5; i++){
            oppoAttack.add(scanner.nextInt());
        }
        for(int i=0; i<5; i++){
            oppoBoold.add(scanner.nextInt());
        }
        //模拟攻击过程
        int xiaoShikigami = 0; //小易此时派出的式神
        int oppoShikigami = 0; //小易对手此时派出的式神
        while(xiaoShikigami<=4 && oppoShikigami<=4){
            //小易先攻击，若对方剩余血量等于或小于攻击力，则直接死亡
            if(xiaoAttack.get(xiaoShikigami) >= oppoBoold.get(oppoShikigami)){
                oppoShikigami++;
            }
            else{
                oppoBoold.set(oppoShikigami,oppoBoold.get(oppoShikigami)-xiaoAttack.get(xiaoShikigami));
            }

            if(oppoShikigami>4){
                break;
            }

            //对手攻击
            if(oppoAttack.get(oppoShikigami) >= xiaoBoold.get(xiaoShikigami)){
                xiaoShikigami++;
            }
            else{
                xiaoBoold.set(xiaoShikigami,xiaoBoold.get(xiaoShikigami)-oppoAttack.get(oppoShikigami));
            }
        }

        if(xiaoShikigami<oppoShikigami){
            System.out.println("win");
            System.out.println(5-xiaoShikigami);
        }
        else {
            System.out.println("lose");
            System.out.println(5-oppoShikigami);
        }
    }
}
