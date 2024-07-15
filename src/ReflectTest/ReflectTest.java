package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectTest
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/26 9:28
 */

public class ReflectTest {

    private static Object s1;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //反射第一步：获取类对象
        Class calssObject = getClassObject();
        //获取类对象的构造器并进行处理，初始化对象返回
        Student s1 = (Student) getClassConstructor(calssObject);
        System.out.println(s1.getName());
        //获取类对象的成员变量，目的是为了赋值
        getField(calssObject,s1);
        //获取类对象的成员方法，目的是为了执行
        getMethod(calssObject,s1);
    }

    //反射第一步：获取类对象的三种方式
    public static Class getClassObject() throws ClassNotFoundException {
        //1、类名.class获取
        Class c1 = Student.class;
        System.out.println(c1.getName());
        //2、class forName获取,系统怕你路径写错，方法要加上异常,事实证明好容易写错
        Class c2 = Class.forName("ReflectTest.Student");
        System.out.println(c2.getName());
        //3、getClass获取
        Class c3 = (new Student()).getClass();
        System.out.println(c3.getName());

        //因为类只加载一次，所以三个引用指向的是同一个对象
        System.out.println(c1==c2);
        System.out.println(c1==c3);
        return c1;
    }

    //反射之获取类的构造器
    public static Object getClassConstructor(Class classObject) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1、获取全部public修饰的构造器
        Constructor[] constructors = classObject.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("public的："+constructor.getName()+"--->"+constructor.getParameterCount());
        }
        //2、获取全部存在的构造器
        Constructor[] declaredConstructors = classObject.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println("全部存在的："+constructor.getName()+"--->"+constructor.getParameterCount());
        }
        //3、获取某个public修饰的构造器，比如传入参数获取有参构造器，String.class才代表String类型
        Constructor constructor = classObject.getConstructor(String.class, int.class, float.class);
        //4、获取某个存在的有参数构造器
        Constructor declaredConstructor = classObject.getDeclaredConstructor(String.class, int.class, float.class);

        //获取类构造器的作用：初始化类对象并返回
       return constructor.newInstance("民哥",26,100);
    }

    //反射之获取类的成员变量
    public static void getField(Class object, Object s1) throws NoSuchFieldException, IllegalAccessException {
        //获取公开的成员变量
        Field[] fields = object.getFields();
        //获取全成员变量
        Field[] declaredFields = object.getDeclaredFields();
        //获取某个成员变量
        //score是private变量，要通过getDeclaredField获取
        Field age = object.getDeclaredField("score");
        //传进来一个类对象实例，并进行它的这个属性赋值
        age.setAccessible(true);//避开安全检查
        age.set(s1,(float)85.5);
        System.out.println(age.get(s1));
    }

    //反射之获取类的成员方法
    public static void getMethod(Class object, Object s1) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method[] methods = object.getMethods();
        Method[] declaredMethods = object.getDeclaredMethods();
        //获取某个成员方法,第二个参数要加上方法接受参数的类型
        Method setAge = object.getDeclaredMethod("setAge",int.class);
        //输出这个成员方法的信息
        System.out.println(setAge.getName()+"---"
                +setAge.getParameterCount()+"---"
                +setAge.getReturnType());
        //执行这个成员方法,无返回值的方法执行完，接受的返回结果自然为null
        Object invoke = setAge.invoke(s1, 55);
        System.out.println(invoke);//null
        //有返回值的方法执行完，接受的返回结果是有的
        //因为该方法没有接受参数，因此下面这句没有第二个参数
        Method getAge = object.getDeclaredMethod("getAge");
        Object invoke1 = getAge.invoke(s1);
        System.out.println(invoke1);
    }

}
