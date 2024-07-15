package AnnotationTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName AnnotationTest3
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/16 16:20
 */

public class analysze {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //通过反射分析类中对于注解的使用情况
        //1、拿到类字节码
        Class ac = AnnotationTest1.class;
        //2、拿到成员方法
        Method testMethod = ac.getDeclaredMethod("test123",String.class);
        //如果该方法上存在注解，则
        if(testMethod.isAnnotationPresent(myAnnotation.class)){
            //拿到这个注解，并打印上面的数据
            myAnnotation declaredAnnotation = testMethod.getDeclaredAnnotation(myAnnotation.class);
            System.out.println(declaredAnnotation.value());
            System.out.println(declaredAnnotation.aaa());
            System.out.println(Arrays.toString(declaredAnnotation.bbb()));
            //最后执行这个方法
            testMethod.setAccessible(true);//使用暴力反射才能获取类对象中的所有信息，不然下面那句会报错
            Object result = testMethod.invoke(new AnnotationTest1(), "这个");
            //打印方法执行后返回的结果
            System.out.println(result);
        }
    }

}
