package com.tank.app.util;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;

/**
 * @ClassName Constant
 * @Description TODO
 * @Author 彭德民
 * @Date 2023/2/27 22:15
 */

public class Constant {

    public static final String GAME_TITLE = "坦克大战";

    public static final int FRAME_HEIGHT = 1000;
    public static final int FRAME_WIDTH = 1210;

    public static final int FRAME_X = 0;
    public static final int FRAME_Y = 0;

    public static final int STATE_MENU = 0;
    public static final int STATE_HELP = 1;
    public static final int STATE_ABOUT = 2;
    public static final int STATE_RUN = 3;
    public static final int STATE_OVER = 4;

    public static final String[] MENUS = {"开始游戏", "继续游戏", "游戏帮助", "游戏关于", "退出游戏"};
    public static final Font GAME_FONT = new Font("宋体", Font.BOLD, 24);

    public static final int REPAINT_INTERVAL = 100;
}
