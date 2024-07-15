package Test;

import java.io.*;
import java.util.Scanner;

/**
 * @ClassName ExceptionTest
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/3/21 11:08
 */

public class ExceptionTest {
    public static void main(String[] args) throws Exception {

        //try catch finally 使用
        try {
            System.out.println("组点啥");
            throw new RuntimeException("出错啦");
        }catch(Exception e){
            System.out.println("haha"+e.getMessage());
        }finally {
            System.out.println("finally"+args.length);
        }

        //简单的try-with-resources，要关闭资源就用它，一个资源
        try(Scanner scanner = new Scanner(new File("test.txt"))){
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        //简单的try-with-resources，要关闭资源就用它，多个资源
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
