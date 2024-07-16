package Test;

import java.util.*;

/**
 * @ClassName GenericTest
 * @Description 对泛型进行学习的类
 * @Author 彭德民
 * @Date 2024/3/21 11:51
 */
public class GenericTest {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1.2实例化泛型类
        Generic<Integer> test = new Generic<Integer>(123456);
        Generic<String> test2 = new Generic<String>("hello world");

        Generic2<Double> test3 = new Generic2<>(122.23);
        //下面句就报错了，因为eneric2<T extends Number>指明类实例化类型必须为数值类型
        //Generic2<String> test3 = new Generic2<>("122.23");

        //3.2泛型方法使用
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        //实际调用泛型方法时根据所传数组类型决定输出数据类型
        printArray(intArray);
        printArray(stringArray);

        //实例:HashSet的加入和遍历
        HashSet<Stu> stus = new HashSet<Stu>();
        stus.add(new Stu("jack", 12));
        stus.add(new Stu("hichael", 18));
        Iterator<Stu> iterator = stus.iterator();
        while (iterator.hasNext()) {
            Stu ss = iterator.next();
            System.out.println(ss.getName());
            System.out.println(ss.getAge());
            System.out.println("-------------------");
        }

        //实例：HsahMap的加入和遍历
        HashMap<String, Stu> hashMap = new HashMap<String, Stu>();
        hashMap.put("marry", new Stu("marry", 78));
        hashMap.put("leao", new Stu("leao", 66));
        hashMap.put("kk", new Stu("kk", 55));
        for (Map.Entry<String, Stu> ele : hashMap.entrySet()) {
            System.out.println(ele.getKey() + " " + ele.getValue().getAge());
        }
        List list = new ArrayList();
        list.add(23);
        String number = (String) list.get(0);


    }

    //3.1、泛型方法声明
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.println(element);
        }
        System.out.println("");
    }
}

//1.1、泛型类声明,使用非限定通配符
class Generic<T> {
    //此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
    //在实例化泛型类时，必须指定T的具体类型
    private T Key;

    public Generic(T Key) {
        this.Key = Key;
    }

    public T getKey() {
        return Key;
    }
}

//1.1、泛型类声明,使用限定通配符，即实现是必须为数字类型
class Generic2<T extends Number> {
    //此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
    //在实例化泛型类时，必须指定T的具体类型
    private T Key;

    public Generic2(T Key) {
        this.Key = Key;
    }

    public T getKey() {
        return Key;
    }
}

//2.1泛型接口声明,使用非限定通配符
interface Generator<T> {
    public T method();
}

//2.2泛型接口实现，不指定类型
class GeneratorImpl<T> implements Generator<T> {
    @Override
    public T method() {
        return null;
    }
}

//2.3泛型接口实现，声明类型
class GeneratorImpl2<T> implements Generator<String> {
    @Override
    public String method() {
        return null;
    }

}


class Stu {
    private String name;
    private Integer age;

    public Stu(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}



