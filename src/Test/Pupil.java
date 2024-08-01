package Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @ClassName Pupil
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/3/15 16:18
 */

public class Pupil extends Student {
    public int id;

    public static void main(String[] args) {
        Pupil p1 = new Pupil();
        p1.testing();

        System.out.println(p1 instanceof Object);
    }

    public Pupil() {
        //super();//不管有没有手动写此句，系统都会执行父类的无参构造器。
        //在父类存在多种构造器的情况下，下面带参数语句会匹配
        // 相应构造器，且必须放在第一行
        super("jack", 18, 90);
        //this(12);
        System.out.println("子类的无参构造器");
    }

    Pupil(int id) {
        this.id = id;
    }

    public void testing() {
        System.out.println("哈哈" + name + "" + age + "" + getScore());
    }

    String ai = new String("000000");

    Deque<Integer> list = new ArrayDeque<Integer>();

}
