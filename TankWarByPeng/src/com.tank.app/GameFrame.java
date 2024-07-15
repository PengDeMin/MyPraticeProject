package com.tank.app;
import static com.tank.app.util.Constant.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName GameFrame
 * @Description 游戏主窗口类
 * @Author 彭德民
 * @Date 2023/2/27 15:48
 */

/*
 *游戏所有展示内容都在该类里实现
 */
public class GameFrame extends Frame implements Runnable{
    //游戏状态
    public static int gameState;
    //菜单指向
    private int menuIndex;

    /*
     *对窗口进行初始化
     */
    public GameFrame() {
        //初始化
        initFrame();
        //注册监听事件
        initEventListener();
        //启动线程
        new Thread(this).start();
    }

    /**
     * 绘制初始化窗口的页面
     */
    private void initFrame(){
        gameState = STATE_MENU;
        //设置标题
        setTitle(GAME_TITLE);
        //由于窗口默认不显示，因此要设置显示
        setVisible(true);
        //窗口大小
        setSize(FRAME_HEIGHT,FRAME_WIDTH);
        //设置游戏窗口居屏幕中间
        setLocationRelativeTo(null);
        //设置窗口大小不可改变
        setResizable(false);
        /**
         *  repaint()方法是一个具有刷新页面效果的方法,若不调用repaint方法图形发生变化后不会立刻显示
         *  repaint调用update()清除当前显示并再调用paint()方法
         *  如果不调用repaint()就不能实现每一次的刷新显示,不能立刻显示就无法马上进行下一步的绘画
         */
        //repaint();
    }

    /**
     * 初始化窗口的事件监听
     */
    private void initEventListener(){
        //注册监听事件
        addWindowListener(new WindowAdapter(){
            //点击关闭按钮时，该方法被自动调用
            @Override
            public void windowClosing(WindowEvent e){
                //关闭虚拟机
                System.exit(0);
            }
        });

        //添加按键的监听事件
        addKeyListener(new KeyAdapter() {
            //按下按键时被回调的方法
            @Override
            public void keyPressed(KeyEvent e){
                //记录按下键的键值，任意一个按键都对应一个整数值
                int keyCode = e.getKeyCode();
                //不同的游戏状态，给出不同的处理方法
                switch (gameState){
                    case STATE_MENU:
                        keyEventMenu(keyCode);
                        break;
                    case STATE_HELP:
                        keyEventHelp(keyCode);
                        break;
                    case STATE_RUN:
                        keyEventRun(keyCode);
                        break;
                    case STATE_OVER:
                        keyEventOver(keyCode);
                        break;

                }
            }

            //松开按键时被回调的方法
            @Override
            public void keyReleased(KeyEvent e){

            }
        });
    }

    /**
     * 是Frame类的方法，继承下来的方法
     * 该方法负责所有绘制的内容，所有需要在屏幕中显示的内容，都要在该方法内调用。
     * 该方法不能主动调用，必须通过调用repaint()；去回调该方法；
     * 每当页面刷新，就会调用update方法，根据游戏所处状态对页面进行重新绘制
     */
    @Override
    public void update(Graphics g){
        g.setFont(GAME_FONT);
        switch (gameState){
            case STATE_MENU:
                drawMenu(g);
                break;
            case STATE_HELP:
                drawHelp(g);
                break;
            case STATE_RUN:
                drawRun(g);
                break;
            case STATE_OVER:
                drawOver(g);
                break;
        }
    }

    //菜单状态需要绘制的内容,graphics是由系统提供的画笔对象
    private void drawMenu(Graphics graphics){
        //绘制黑色背景
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0,FRAME_WIDTH,FRAME_HEIGHT);

        final int STR_WIDTH = 66;
        int x = FRAME_WIDTH - STR_WIDTH >>1;
        int y = FRAME_HEIGHT / 3;
        //行间距
        final int DIS = 50;
        for (int i = 0; i < MENUS.length; i++) {
            if (i == menuIndex) {
                //设置选中菜单项的颜色为红色
                graphics.setColor(Color.RED);
            } else {
                graphics.setColor(Color.WHITE);
            }

            graphics.drawString(MENUS[i],x,y+DIS * i);
        }
    }

    //游戏结束需要绘制的内容
    private void drawOver(Graphics g) {
    }

    //游戏运行中需要绘制的内容
    private void drawRun(Graphics g) {
        //绘制黑色背景
        g.setColor(Color.BLACK);
        g.fillRect(0, 0,FRAME_WIDTH,FRAME_HEIGHT);
    }

    //游戏帮助需要绘制的内容
    private void drawHelp(Graphics g) {
    }

    //结束状态下的按键处理
    private void keyEventOver(int keyCode) {
    }

    //运行状态下的按键处理
    private void keyEventRun(int keyCode) {
    }

    //帮助状态下的按键处理
    private void keyEventHelp(int keyCode) {
    }

    //菜单状态下的按键处理
    private void keyEventMenu(int keyCode) {
        switch (keyCode) {
        case KeyEvent.VK_UP:
        case KeyEvent.VK_W:
            if (--menuIndex < 0){
                menuIndex = MENUS.length - 1;
            }
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            if (++menuIndex > MENUS.length - 1) {
                menuIndex = 0;
            }
            break;
        //按下enter键启动游戏之后的操作
        case KeyEvent.VK_ENTER:
            newGame();
            break;
        }
    }

    /**
     * 开始新游戏的方法
     */
    private void newGame() {
        gameState = STATE_RUN;
        //创建自己和敌人的坦克对象
    }

    /**
     * 通过线程来控制窗口自动刷新重绘
     */
    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
