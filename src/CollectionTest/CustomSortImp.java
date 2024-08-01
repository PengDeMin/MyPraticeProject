package CollectionTest;

import Test.Pupil;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author：彭德民
 * @ClassName：CustomSortImp
 * @Date：2024/7/31 15:24
 * @Description：自定义比较排序器的实现
 */

public class CustomSortImp {
    public static void main(String[] args) {

        //匿名内部方法方式
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(!(o1 instanceof Student) || !(o2 instanceof Student)){
                    throw new RuntimeException("不是Integer类型");
                }
                if (o1 == o2) return 0;
                Student p1 = (Student) o1;
                Student p2 = (Student) o2;
                //1、先比较姓名
                int num = p1.getName().compareTo(p2.getName());
                if(num == 0){
                    //2、再比较年龄
                    //注意先装箱成Integer类型,因为引用类型才能调用compareTo方法
                    return new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
                }
                return num;
            }
        });

        //Lambda表达式方式
        TreeSet ts2 = new TreeSet((o1,o2) -> {

            if(!(o1 instanceof Student) || !(o2 instanceof Student)){
                throw new RuntimeException("不是Integer类型");
            }
            if (o1 == o2) return 0;
            Student p1 = (Student) o1;
            Student p2 = (Student) o2;
            //1、先比较姓名
            int num = p1.getName().compareTo(p2.getName());
            if(num == 0){
                //2、再比较年龄
                //注意先装箱成Integer类型,因为引用类型才能调用compareTo方法
                return new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
            }
            return num;
        });

        Set<Student> t3 = ts2.headSet(new Student("张三", 18));
        ts2.comparator().compare(new Student("张三", 18), new Student("李四", 19));
    }
}
