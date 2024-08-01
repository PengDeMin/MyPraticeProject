package CollectionTest;

import java.util.Comparator;
import java.util.Objects;

/**
 * @Author：彭德民
 * @ClassName：Student
 * @Date：2024/7/31 15:07
 * @Description：
 * (1)重写equals和hashCode方法来比较对象
 * (2)重写排序器
 */

public class Student implements Comparable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    /**
     * @Description 重写方法比较是否相等
     * @Date 2024/7/31 15:09
     * @Param [obj]
     * @Return boolean
     **/
    @Override
    public boolean equals(Object obj) {
        //1、先看是否为空以及比较类是否相同
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        //2、经过上面那一步，再把obj向下转型，此时不会出现ClassCastException异常
        Student rewriteTest = (Student) obj;
        //3、比较值是否相等
        return this.name.equals(rewriteTest.name) && this.age == rewriteTest.age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode())*prime;
        result = prime * result + age*prime;
        return result;
    }


    public int hashCode1() {
        return Objects.hash(name,age);
    }

    /**
     * @Description 先比较年龄再比较名字
     * @Date 2024/7/31 15:51
     * @Param [o]
     * @Return int
     **/
    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Student)){
            throw new RuntimeException("类型不匹配");
        }
        Student student = (Student) o;
        if(this.age > student.age){
            return 1;
        }else if(this.age < student.age){
            return -1;
        }else{
            return this.getName().compareTo(student.getName());
        }
    }
}
