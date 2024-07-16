package AnnotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName myAnnotation
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/16 16:14
 */
@Target({ElementType.TYPE, ElementType.METHOD})//指定该自定义注解可以在类、方法上使用
@Retention(RetentionPolicy.RUNTIME)//指定该自定义注解一直保留到运行时
public @interface myAnnotation {

    String value();

    double aaa() default 100;

    String[] bbb();
}
