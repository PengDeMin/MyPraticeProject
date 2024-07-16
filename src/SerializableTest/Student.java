package SerializableTest;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description 可以序列化和反序列的学生类对象
 * @Author 彭德民
 * @Date 2024/3/15 16:16
 */

public class Student implements Serializable {
    //显示指定serialVersionUID，防止日后类修改迭代，导致旧对象反序列化时报错
    private static final long serialVersionUID = -975322224259717408L;
    public String name;
    public int age;
    private float score;
    public transient String hobby;//不会被反序列化的字段

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    //无参构造器
    Student() {
        System.out.println("父类的无参构造器");
    }

    //有参构造器
    Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    //如果不重写toString方法，直接打印输出学生对象，输出的
    //是学生类的名字+对象存储hashCode，如：SerializableTest.Student@30c7da1e
    @Override
    public String toString() {
        return "Student [name=" + name +
                ", age=" + age +
                ", score=" + score +
                ", hobby= " + hobby + "]";
    }
}
