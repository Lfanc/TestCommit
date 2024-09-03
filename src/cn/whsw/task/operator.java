package cn.whsw.task;

import java.util.Scanner;

public class operator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(">>>");
        op(input.nextInt());
    }

    public static void op(int num){
        int ans = 0;
        int[] list = new int[3];
        for (int i=0;i<3;i++){
            ans = num%10;
            list[i] = ans;
            num /= 10;
        }
        for(int i=2;i>=0;i--){
            System.out.println(list[i]);
        }
    }
}
