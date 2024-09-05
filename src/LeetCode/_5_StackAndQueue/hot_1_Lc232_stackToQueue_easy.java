package LeetCode._5_StackAndQueue;

import java.util.Stack;

/**
 * @Author：彭德民
 * @ClassName：_Lc232_stackToQueue_easy
 * @Date：2024/9/5 9:18
 * @Description：用两个栈实现先进先出队列
 * 说白了，用编程语言提供的栈及push、pop等方法实现一个自己的队列，并对外暴露队列的接口，
 */

public class hot_1_Lc232_stackToQueue_easy {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    // 初始化队列，底层就是初始化两个栈
    public hot_1_Lc232_stackToQueue_easy() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    //元素进队列尾
    public void push(int x){
        // 将元素压入输入栈
        stackIn.push(x);

    }

    //对头元素出队列
    public int pop(){
        dumpStackIn();
        return stackOut.pop();//元素要出来
    }

    //获取队列头部元素，注意元素并不出队
    public int peek() {
        dumpStackIn();
        return stackOut.peek();//只获得元素，但元素不能出来
    }

    //判断队列是否为空
    public boolean empty() {
        //实现队列的底部两个栈都为空，则队列为空
        return stackIn.isEmpty()&& stackOut.empty();
    }

    public  void dumpStackIn(){
        //如果输出栈不为空，说明之前队列的头部元素已经被输入栈弹出，压入到在输出栈中
        if(!stackOut.isEmpty()) return;

        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

}
