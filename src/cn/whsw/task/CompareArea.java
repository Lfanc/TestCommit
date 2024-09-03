package cn.whsw.task;

public class CompareArea {
    public static void main(String[] args) {
        System.out.println(CA(20));
    }

    public static double CA(int l){
        int squareArea = l*l;
        double circleArea = 3.14*(l/2)*(l/2);
        double result = squareArea-circleArea;
        return result;

    }
}
