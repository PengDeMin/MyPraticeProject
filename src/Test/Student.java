package Test;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/3/15 16:16
 */

public class Student {
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
}
