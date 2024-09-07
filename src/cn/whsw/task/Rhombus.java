package cn.whsw.task;

public class Rhombus {


    public static void print(int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.println(" ");
            }
            for(int j=0;j<2*i-1;j++){
                System.out.println("*");
            }
        }

        for(int i=n-1;i>0;i--){
            for(int j=0;j<n-i;j++){
                System.out.println(" ");
            }
            for(int j=0;j<2*i-1;j++){
                System.out.println("*");
            }
        }
    }
}
