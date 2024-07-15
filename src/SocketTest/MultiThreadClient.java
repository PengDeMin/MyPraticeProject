package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @ClassName MultiThreadClient
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/4/29 21:45
 */

public class MultiThreadClient {
    public static void main(String[] args) {
        int numTasks = 10;
        ExecutorService exec = Executors.newCachedThreadPool();
//客户端创建可变数量的线程池
        for (int i = 0; i < numTasks; i++) {//客户端负责执行自己的线程任务
            exec.execute(createTask(i));
        }

    }

    // 定义一个简单的任务
    private static Runnable createTask(final int taskID) {
        return new Runnable() {
            private Socket socket = null;
            private int port=8821;

            @Override
            public void run() {
                System.out.println("任务" + taskID + ":启动");
                try {                    
                    socket = new Socket("localhost", port);//客户端建立socket
                    // 发送关闭命令
                    OutputStream socketOut = socket.getOutputStream();
                    socketOut.write(("服务器，我（客户端,任务:" + taskID + "）要关闭了嗷!\r\n").getBytes());

                    // 接收服务器的反馈
                    BufferedReader br = new BufferedReader(
                                                        new InputStreamReader(socket.getInputStream()));
                    String msg = null;
                    while ((msg = br.readLine()) != null)//读取输入流内容
                    {
                        System.out.println(msg+"你好");
                    }
                } catch (IOException e) {                    
                    e.printStackTrace();
                }
            }

        };
    }
}
