package cn.whsw.task;



import java.util.Scanner;

public class Avg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double ageSum = 0;
        int i = 0;
        while (true) {
            int num = scan.nextInt();
            if ((num > 1) && (num < 100)) {
                while (i < num) {
                    int age = scan.nextInt();
                    if (age > 15 && age < 55) {
                        ageSum += age;
                        i++;
                    } else {
                        System.out.println("请输入（15，55）区间的年龄");
                    }

                }
                System.out.printf("%.2f", ageSum / num);
                break;
            }else{
                System.out.println("请输入（1，100）区间的整数");
            }
        }
    }
}
