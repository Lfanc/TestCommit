package cn.whsw.task;

import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                arr[j][i] = scanner.nextInt();
            }
        }

        for (int[] i:arr){
            for (int j:i){
                System.out.printf("%d ",j);
            }
            System.out.println();
        }
    }
}
