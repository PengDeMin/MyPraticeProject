package ReflectTest;

/**
 * @ClassName Student
 * @Description 试验反射的例子
 * @Author 彭德民
 * @Date 2024/3/15 16:16
 */

public class Student {
    public String name;
    public int age;
    private float score;

    //无参构造器
    Student(){
        System.out.println("父类的无参构造器");
    }

    //有参构造器
    public Student(String name, int age, float score){
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
        System.out.println("这是一个获取年龄的方法");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("这是一个设置年龄的方法");
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
