package AnnotationTest;

/**
 * @ClassName AnnotationTest1
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/5/16 16:16
 */

public class AnnotationTest1 {


    private String value;

    @myAnnotation(value = "彭德民",aaa = 199.9,bbb = {"帅哥","美女"})
    private String test123(String value22){
        System.out.println("现在执行这个带了注解的方法:"+value22);
        return "这个带有注解的方法执行完了，返回一个结果给你";
    }
}
