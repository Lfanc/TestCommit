package cn.whsw.task;


import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        menuView();
    }


    // -------------------- 数据设计 --------------------
/*
    棋盘:
        map[i][j]表示坐标(i,j)的值
        0表示空地
        1表示黑子
        2表示白子
    如: map[3][6] = 1  表示(3,6)的位置是黑子
*/
    public static int[][] map = new int[19][19];

    // 表示当前回合数  偶数表示黑棋落子  奇数表示白棋落子
// 如: flag = 20 表示当前是第[20]次落子  由黑方落子
    public static int flag;
// -------------------- 数据设计 --------------------


    // -------------------- service --------------------
/*
    负责人: 张三
    功能: 初始化游戏数据
        将棋盘的值初始化为0
        当前回合设为黑棋(flag设为0)
    参数: void
    返回值: void
*/
    public static void init(){
        //在此处完成代码
        for (int i=0;i<19;i++){
            Arrays.fill(map[i], 0);
        }
        flag = 0;//黑棋先手
    }

    /*
        *难点1
        负责人: 张三
        功能: 根据传入的坐标(map对应位置)和flag值 判断落点后是否获胜
        参数:
            x: 当前回合落子的x坐标
            y: 当前回合落子的y坐标
        返回值:
            0表示没有获胜
            1表示黑子胜利
            2表示白子胜利
    */


    public static int isWin(int x, int y){

        //在此处完成代码
        int num = -1;//记录连续棋子的个数，-1是因为两重判定把原始坐标判定了两次
        int chess;//用于本回合要判断的棋子
        int originX = x;//记录原始坐标
        int originY = y;
        if (flag%2==0) {
            chess = 1;
        }else chess = 2;
        //上下扫描 |
        //向上扫描,防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                x--;
            } else break;
        }
        x = originX;
        //向下扫描,防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                x++;
            } else break;
        }
        System.out.println("====目前|有"+num+"颗");
        if (num==5){
            if (flag%2==0){
                return 1;

            } else return 2;
        }
        //左右扫描 --
        num = -1;
        x = originX;
        //向左扫描,防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                y--;
            } else break;
        }
        y = originY;
        //向右扫描，防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                y++;
            } else break;
        }
        if (num==5){
            if (flag%2==0){
                return 1;

            } else return 2;
        }

        //斜向右扫描 /
        num = -1;
        x = originX;
        y = originY;
        //斜向上右扫描，防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                x--;
                y++;
            } else break;
        }
        x = originX;
        y = originY;
        //斜向下左扫描，防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                x++;
                y--;
            } else break;
        }
        if (num==5){
            if (flag%2==0){
                return 1;

            } else return 2;
        }

        //斜向左扫描 \
        num = -1;
        x = originX;
        y = originY;
        //斜向上左扫描，防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                x--;
                y--;
            } else break;
        }
        x = originX;
        y = originY;
        //斜向下右扫描，防止越界
        while ((x >= 0 && x <= 18) && (y >= 0 && y <= 18)) {
            if (map[x][y] == chess) {
                num += 1;
                x++;
                y++;
            } else break;
        }

        if (num==5){
            if (flag%2==0){
                return 1;

            } else return 2;
        }
        return 0;
    }

    /*
        负责人: 张三
        功能: 在指定位置落子
            如果map[x][y]是空地 则修改map[x][y]的值:改为相应颜色(flag对应颜色)
            否则不操作
        参数:
            x: 当前回合落子的x坐标
            y: 当前回合落子的y坐标
        返回值:
            0表示落子失败 (棋盘已经有子)
            1表示落子成功

    */
    public static int playerMove(int x, int y){
        //在此处完成代码
        if ((x>=0&&x<=18)&&(y>=0&&y<=18)) {//判断是否越界
            if(map[x][y]==0){//判断是否为空
                if (flag%2==0){
                    map[x][y] = 1;
                }else
                    map[x][y] = 2;
                return 1;
            } else System.out.println("请输入正确的坐标！");
        } else System.out.println("请输入正确的坐标！");
        return 0;
    }
// -------------------- service --------------------



    // -------------------- view --------------------
/*
    功能: 展示选项, 玩家可以在这里选择进入游戏, 进入设置或退出游戏
        进入游戏: 调用游戏界面函数gameView();
        进入设置: 敬请期待...
        退出游戏: 调用exit(0);
*/
    public static void menuView(){
        //在此处完成代码
        gameView();


    }

    /*
        负责人: 张三
        功能: 根据map数组 打印游戏棋盘
        参数: void
        返回值: void
    */
    public static void gameView_ShowMap(){
        //在此处完成代码
        System.out.println("   "+"0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
        for(int i=0;i<19;i++){
            if (i<10) {
                System.out.print(i+" ");
            } else System.out.print(i);
            System.out.println(Arrays.toString(map[i]));
        }
    }

    /*
        负责人: 张三
        功能: 根据flag的值  打印游戏胜利界面  用户可以按任意键回到主菜单
        参数: void
        返回值: void
    */
    public static void winView(){
        //在此处完成代码
        if (flag%2==0){
            System.out.println("----------黑棋胜利---------");
        } else System.out.println("----------白棋胜利---------");



    }

    /*
        *难点2
        负责人: 张三
        功能: 游戏界面整合
            初始化游戏数据(调用函数init())
            while(1){
                打印游戏界面(调用函数gameView_ShowMap())
                接收玩家坐标输入

                落子(调用落子函数playerMove())
                    (如果落子失败 重新开始循环)

                判断游戏是否胜利(调用胜利判断函数isWin())
                    (如果游戏胜利 调用胜利界面函数 然后结束当前界面)
                切换玩家(修改flag值)
            }
        参数: void
        返回值: void
    */
    public static void gameView(){
        //在此处完成代码
        init();
        while(true){
            System.out.println("---------------第["+flag+"]次落子---------------");
            gameView_ShowMap();
            if (flag%2==0){
                System.out.println("-------黑棋回合-------");
            } else System.out.println("-------白棋回合-------");
            System.out.println("请输入横坐标：");
            int x = scan.nextInt();
            System.out.println("请输入纵坐标：");
            int y= scan.nextInt();
            if(playerMove(x,y)==0){
                continue;
            }
            if(isWin(x,y)!=0){
                winView();
                break;
            }
            flag++;

        }
    }
// -------------------- view --------------------
}

