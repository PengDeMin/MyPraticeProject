package SerializableTest;

import java.io.*;

/**
 * @ClassName serializableDemo
 * @Description 对学生类对象进行序列化和反序列化的测试DEMO
 * @Author 彭德民
 * @Date 2024/5/15 16:24
 */

public class serializableDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("pengdemin");
        s1.setAge(25);
        s1.setScore(88);
        s1.setHobby("running");
        //直接打印s1和打印s1.toString()是一个效果
        System.out.println(s1);
        //将s1对象序列化保存到文件中
        try (FileOutputStream fos = new FileOutputStream("serial");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从文件中读取s1对象并进行反序列化，然后输出值
        File file = new File("serial");
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            Student s2 = (Student) ois.readObject();
            System.out.println(s2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
