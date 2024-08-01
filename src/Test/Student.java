package Test;

import java.util.Comparator;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/3/15 16:16
 */

public class Student implements Comparable {
    public String name;
    public int age;
    private float score;

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


    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("不是正确对象");
        }

        Student p = (Student) obj;
        if (p.age > this.age) {
            return -1;
        }
        //1、先比较年龄，再比较名字
        if (p.age == this.age) {
            return this.name.compareTo(p.name);
        }
        return 1;
    }
}
