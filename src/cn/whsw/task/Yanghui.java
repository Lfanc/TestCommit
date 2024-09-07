package cn.whsw.task;

import java.util.Scanner;

public class Yanghui {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        while(true){
            System.out.println("请输入(1，10)区间的数：");
            num = scan.nextInt();
            if(num>1&&num<10){
                int[][] arr = new int[num][num];
                for(int i=0;i<num;i++){
                    for(int j=0;j<=i;j++){
                        if(j==0 || j==i){
                            arr[i][j] = 1;
                            System.out.print("1 ");
                        } else {
                            arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                            System.out.printf("%d ",arr[i][j]);
                        }
                    }
                    System.out.println();
                }
                break;
            }
        }
        scan.close();
    }
}
