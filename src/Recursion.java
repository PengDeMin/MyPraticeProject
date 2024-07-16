/**
 * @ClassName Recursion
 * @Description 递归案例代码
 * @Author 彭德民
 * @Date 2024/3/12 15:29
 */

class Recurison {
    public static void main(String[] args) {
        T t1 = new T();
        int n = 6;
        //System.out.println("第"+n+"个数为："+t1.getFibonacci(n));
        n = 1;
        //System.out.println("第"+n+"天还剩"+t1.getPeachNum(n)+"个桃子");
        //t1.mazeGame();
        //t1.hanoiTowerGame(3,'A','B','C');

        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
    }
}

class T {

    //1、获取斐波那契数列：1,1,2,3,5,8,11.....
    public int getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }

    //2、获取猴子吃桃子第N天所剩桃子数量
    // 猴子每天都吃所剩桃子数量的一半再对一个，第10天只剩下1个桃子
    public int getPeachNum(int n) {
        if (n == 10) {
            //m = 1;
            return 1;
        } else if (n >= 1 && n <= 9) {
            return (getPeachNum(n + 1) + 1) * 2;
        } else {
            System.out.println("天数范围为1~10");
            return -1;
        }
    }

    //3、找迷宫游戏
    public void mazeGame() {
        int[][] maze = drawMaze();
        outMaze(maze);
        //(1,1)表示起点从1,1开始
        System.out.println(findWay(maze, 1, 1));
        outMaze(maze);
    }

    //画一个迷宫
    public int[][] drawMaze() {
        int[][] map = new int[8][7];
        //改变最上最下两行
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //改变最左最右两列
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    //输出当前迷宫地图
    public void outMaze(int[][] map) {
        System.out.println("当前地图");
        for (int[] row : map) {
            for (int temp : row) {
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }

    //制定找出路策略
    //0表示可以走 1表示有障碍不能走 2 表示已经走过且能走 3 表示走过但走不通是死路
    public boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//说明已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //此步可以走,所以走一下并置为2
                map[i][j] = 2;
                //制定具体的先后策略，下-》右》上-》左
                if (findWay(map, i + 1, j)) {
                    //这里的返回true意思可以是继续往下走
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    //下右上左都试过走不通则判定为死路,并进行标记，
                    // 然后结束此次循环并回溯到上一步
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }

    }

    //4、汉诺塔游戏,输出汉诺塔的移动过程
    public void hanoiTowerGame(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
        } else {
            //将所有盘子分成两个部分，最下一面的一个盘为第二部分，上面的n-1个盘为第一部分
            //先将上面第一部分通过C塔移动到B塔
            hanoiTowerGame(n - 1, A, C, B);
            //然后将下面第二部分移动到C塔
            System.out.println(A + "->" + C);
            //最后将B塔的第一部分借助A塔移动到C塔，叠加在第二部分上面，完成任务
            hanoiTowerGame(n - 1, B, A, C);
        }
    }

    //可变参数,将可变参数当成数组来看待和处理
    public int varCal(int... nums) {
        System.out.println("接收参数个数：" + nums.length);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }


}
