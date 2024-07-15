package CreationalPatterns.FactoryMethod.Test1;

/**
 * @ClassName code1
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/3/12 15:29
 */

public class code1 {
    public static void main(String[] args){
       T t1 = new T();
       int n = 6;
       System.out.println("第"+n+"个数为："+t1.getFibonacci(n));
    }
}

class T{

    //获取斐波那契数列
    public int getFibonacci(int n){
        if(n==1 || n==2){
            return 1;
        }
        else{
            return getFibonacci(n-1)+getFibonacci(n-2);
        }
    }

}
