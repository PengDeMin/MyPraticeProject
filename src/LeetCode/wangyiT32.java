package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName wangyiT32
 * @Description TODO
 * @Author 彭德民
 * @Date 2024/6/20 21:06
 */

public class wangyiT32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();//星系建筑数量
        List<Planet> worlds = new ArrayList<>();

        worlds.sort(new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.radius- o2.radius;
            }
        });

        //1、输入星系每个坐标的值和影响力
        for (int i = 0; i < n; i++) {
            worlds.add(new Planet(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        }
        List<Planet>sortWorlds = worlds.stream().sorted(Comparator.comparingInt(Planet::getRadius)
                .thenComparing(Planet::getxCoor)
                .thenComparing(Planet::getyCoor))
                .collect(Collectors.toList());

        int q = scanner.nextInt();//询问次数
        int[] res = new int[q];
        //2、输入询问坐标并判断被影响数量
        for (int i = 0; i < q; i++) {
            int xRequest = scanner.nextInt();
            int yReuqest = scanner.nextInt();
            int influenced = 0;
        }
    }
}

class Planet{
    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    int xCoor;
    int yCoor;
    int radius;

    public Planet(int xCoor, int yCoor, int radius) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.radius = radius;
    }
}