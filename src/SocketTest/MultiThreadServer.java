package SocketTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.concurrent.*;
/**
 * @ClassName MultiThreadServer
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/29 21:40
 */

public class MultiThreadServer {
    private int port=8821;
    private ServerSocket serverSocket;
    private ExecutorService executorService;//线程池
    private final int POOL_SIZE=10;//单个CPU线程池大小
        
    public MultiThreadServer() throws IOException{
        serverSocket=new  ServerSocket(port);
        //Runtime的availableProcessor()方法返回当前系统的CPU数目.
        executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);//工厂类创建固定线程数（CPU核心数*每个U        线程池大小）的线程池
        System.out.println("民哥服务器，启动！");
    }
        
    public void service(){//服务方法负责打开端口，执行服务器线程方法
        while(true){
            Socket  socket=null;//客户端请求服务器打开的socket
            try  {
                //接收客户连接,只要客户进行了连接,就会触发accept();从而建立连接
                socket=serverSocket.accept();
                executorService.execute(new  Handler(socket));//连接后执行excute（）
            } catch(Exception  e) {
                e.printStackTrace();
            }
        }
    }
        
    public static void main(String[] args) throws IOException  {
        new  MultiThreadServer().service();
    }

}

class Handler implements Runnable{
    private Socket socket;
    public Handler(Socket socket){//传一个socket进来
        this.socket=socket;
    }

    private PrintWriter getWriter(Socket  socket)  throws  IOException{
        OutputStream  socketOut=socket.getOutputStream();
        return  new  PrintWriter(socketOut,true);
    }

    private BufferedReader  getReader(Socket  socket)  throws  IOException{
        InputStream  socketIn=socket.getInputStream();
        return  new  BufferedReader(new  InputStreamReader(socketIn));
    }

    public  String  echo(String  msg){
        return  "echo:"+msg;
    }

    @Override
    public  void  run(){//线程池中execute（）就执行这个方法
        try  {
            System.out.println(" 收到彭德民客户端的新连接：  "+socket.getInetAddress()+":"+socket.getPort());
            BufferedReader  br=getReader(socket);//获取输入流
            PrintWriter  pw=getWriter(socket);//获取输出流
            String  msg=null;
            while((msg=br.readLine())!=null){//读输入流
                System.out.println(msg);
                pw.println(echo(msg));
                if(msg.equals("bye")) {
                    break;
                }
            }
        }  catch (IOException  e)  {
            e.printStackTrace();
        }finally{
            try  {
                if(socket!=null) {
                    socket.close();
                }
            }  catch  (IOException  e) {
                e.printStackTrace();
            }
        }
    }
}
